package org.example.interfaz;

import com.mongodb.MongoException;
import org.example.dao.PlayerDAO;
import org.example.dao.TeamDAO;
import org.example.model.dto.Player;
import org.example.model.dto.Team;
import org.example.service.FumbblApi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImportarEquipo extends JFrame {
    private JPanel lbl2;
    private JLabel lblNombre;
    private JLabel lblCoach;
    private JLabel lblRoster;
    private JLabel lblJugadores;
    private JLabel lblValor;
    private JTextField txtIdEquipo;
    private JTextField txtNombre;
    private JTextField txtEntrenador;
    private JTextField txtRoster;
    private JTextField txtValor;
    private JTextField txtJugadores;
    private JButton btnVerJugadores;
    private JButton btnGuardarEnMongo;
    private JButton limpiarButton;
    private JButton buscarJugadorButton;
    private FumbblApi apiService;
    private TeamDAO teamDAO;
    private PlayerDAO playerDAO;
    private JPanel panelTabla;

    // Equipo actual
    private Team teamActual;
    private JTable tableJugadores;
    private DefaultTableModel tableModel;
    public VentanaImportarEquipo() {

        setTitle("FUMBBL");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(lbl2);

        apiService = new FumbblApi();
        teamDAO = new TeamDAO();
        playerDAO = new PlayerDAO();

        String[] columnas = {"#", "Nombre", "Posición", "TDs", "Habilidades"};
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableJugadores = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableJugadores);

        if (panelTabla != null) {
            panelTabla.setLayout(new BorderLayout());
            panelTabla.add(scrollPane, BorderLayout.CENTER);
        }



        btnGuardarEnMongo.addActionListener(e -> guardarEnMongo());
        btnGuardarEnMongo.setEnabled(false);
        buscarJugadorButton.addActionListener(e -> buscarEquipo());

        limpiarButton.addActionListener(e -> limpiar());

        txtIdEquipo.addActionListener(e -> buscarEquipo());

        btnVerJugadores.addActionListener(e -> {
            if (teamActual != null) {
                JOptionPane.showMessageDialog(this,
                        "El equipo tiene " + teamActual.getPlayers().size() + " jugadores.\n" +
                                "Puedes verlos en la tabla de abajo.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Primero busca un equipo",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        });





    }
    private void buscarEquipo(){
        String texto = txtIdEquipo.getText().trim();

        if (texto.isEmpty()) {
            return;
        }
        try {
            int teamId = Integer.parseInt(texto);
            buscarJugadorButton.setEnabled(false);
            SwingWorker<Team, Void> worker = new SwingWorker<>() {
                @Override
                protected Team doInBackground() {
                    return apiService.getTeamById(teamId);
                }

                @Override
                protected void done() {
                    try {
                        teamActual = get();
                        if (teamActual != null) {
                            mostrarDatos(teamActual);
                            btnGuardarEnMongo.setEnabled(true);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"NO EXISTE EQUIPO CON DICHO ID");
                        e.printStackTrace();
                        limpiar();
                    }
                }
            };
            worker.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"NO EXISTE EQUIPO CON DICHO ID");
            ex.printStackTrace();
            limpiar();
        }
    }
    private void mostrarDatos(Team team){
        txtNombre.setText(team.getName());
        txtEntrenador.setText((team.getCoach() != null ? team.getCoach().getName() : "-"));
        txtRoster.setText((team.getRoster() != null ? team.getRoster().getName() : "-"));
        txtValor.setText(String.format("%,d", team.getTeamValue()));
        txtJugadores.setText(String.valueOf((team.getPlayers() != null ? team.getPlayers().size() : 0)));
        tableModel.setRowCount(0);

        if (team.getPlayers() != null) {
            for (Player player : team.getPlayers()) {
                String skills = player.getSkills() != null ?
                        String.join(", ", player.getSkills()) : "-";

                int touchdowns = player.getRecord() != null ?
                        player.getRecord().getTouchdowns() : 0;

                Object[] fila = {
                        player.getNumber(),
                        player.getName(),
                        player.getPosition(),
                        touchdowns,
                        skills
                };

                tableModel.addRow(fila);
            }
        }
    }
    private void guardarEnMongo(){
        if (teamActual==null){
            return;
        }
        int confirmacion=JOptionPane.showConfirmDialog(null,"¿Guardar el equipo "
                +teamActual.getName()+" y sus "+teamActual.getPlayers().size()+" jugadores en mongo?","Confirmar Guardado",JOptionPane.YES_NO_OPTION);

        if (confirmacion==JOptionPane.YES_OPTION){
            btnGuardarEnMongo.setEnabled(false);
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground()  {

                    teamDAO.insertarTeam(teamActual);

                    for (Player player : teamActual.getPlayers()) {
                        player.setTeamId(teamActual.getId());
                        playerDAO.insertarPlayer(player);
                    }

                    return null;
                }
                @Override
                protected void done(){
                    try{
                        get();
                        JOptionPane.showMessageDialog(VentanaImportarEquipo.this,
                                "Equipo y jugadores guardados correctamente en MongoDB",
                                "Guardado exitoso",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                    }catch (Exception e){
                        String mensaje = e.getCause() instanceof MongoException ?
                                "El equipo ya existe en MongoDB (ID duplicado)" :
                                "Error al guardar: " + e.getMessage();
                        JOptionPane.showMessageDialog(VentanaImportarEquipo.this,
                                mensaje,
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                        btnGuardarEnMongo.setEnabled(true);
                        e.printStackTrace();
                    }
                }
            };
            worker.execute();
        }
    }
    private void limpiar(){
        txtIdEquipo.setText("");
        txtJugadores.setText("");
        txtNombre.setText("");
        txtRoster.setText("");
        txtEntrenador.setText("");
        txtValor.setText("");
        tableModel.setRowCount(0);
        teamActual = null;
        btnGuardarEnMongo.setEnabled(false);
        btnGuardarEnMongo.setText("Guardar en MongoDB");
        buscarJugadorButton.setText("Buscar");
        buscarJugadorButton.setEnabled(true);
        txtIdEquipo.requestFocus();
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(() -> {
            VentanaImportarEquipo ventana = new VentanaImportarEquipo();
            ventana.setVisible(true);
        });
    }
}
