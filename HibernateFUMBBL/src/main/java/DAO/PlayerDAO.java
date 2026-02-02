package DAO;

import Entidades.PlayersEntity;
import Entidades.TeamsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.HibernateUtil;

import java.util.List;

public class PlayerDAO {
    public PlayersEntity buscarPorId(Integer id){

        EntityManager em= HibernateUtil.getEntityManger();
        PlayersEntity players= em.find(PlayersEntity.class,id);
        em.close();
        return players;
    }
    public List<PlayersEntity> listarJugadores(){

        EntityManager em=HibernateUtil.getEntityManger();
        List<PlayersEntity> lista=em.createQuery("FROM PlayersEntity ",PlayersEntity.class).getResultList();
        em.close();
        return lista;
    }
    public List<PlayersEntity> buscarPorNombre(String nombre){
        EntityManager em=HibernateUtil.getEntityManger();

        List<PlayersEntity> equipo=em.createQuery("FROM PlayersEntity t where t.name LIKE :nombre",PlayersEntity.class)
                .setParameter("nombre","%"+nombre+"%")
                .getResultList();
        em.close();

        return equipo;
    }

    public List<PlayersEntity> buscarPorIdEquipo(int teamId){

        EntityManager em=HibernateUtil.getEntityManger();
        List<PlayersEntity> lista=em.createQuery("FROM  PlayersEntity p where p.teamId= :teamId ",PlayersEntity.class)
                .setParameter("teamId",teamId)
                .getResultList();
        em.close();
        return lista;
    }

    public List<PlayersEntity> maximosGoleadores(int limite){

        EntityManager em=HibernateUtil.getEntityManger();
        List<PlayersEntity> lista=em.createQuery("from PlayersEntity  p order by p.touchdowns desc ",PlayersEntity.class)
                .setMaxResults(limite)
                .getResultList();

        em.close();
        return lista;
    }

    public List<PlayersEntity> buscarPorPosicion(String position){

        EntityManager em=HibernateUtil.getEntityManger();
        List<PlayersEntity> lista=em.createQuery("from PlayersEntity  p where position =:position",PlayersEntity.class)
                .setParameter("position",position)
                .getResultList();

        em.close();
        return lista;
    }


    public void guardarJugador(PlayersEntity equipo){
        EntityManager em=HibernateUtil.getEntityManger();
        EntityTransaction tx= em.getTransaction();

        try {
            tx.begin();
            em.persist(equipo);
            tx.commit();
            System.out.println("Equipo guardado: "+equipo.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        em.close();
    }
    public void actualizarEquipo(PlayersEntity jugador){
        EntityManager em=HibernateUtil.getEntityManger();
        EntityTransaction tx= em.getTransaction();

        try {
            tx.begin();
            em.merge(jugador);
            tx.commit();
            System.out.println("Jugador actualizado: "+jugador.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        em.close();
    }
    public void borrarEquipo(Integer idJugador){
        EntityManager em=HibernateUtil.getEntityManger();
        EntityTransaction tx= em.getTransaction();

        try {
            tx.begin();
            PlayersEntity equipo=em.find(PlayersEntity.class,idJugador);
            if (equipo!=null)
            {
                em.remove(equipo);
                System.out.println("Equipo Borrado: "+equipo.getName());
            }
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        em.close();
    }
}
