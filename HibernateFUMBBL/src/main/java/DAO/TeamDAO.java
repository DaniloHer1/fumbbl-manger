package DAO;

import Entidades.TeamsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import util.HibernateUtil;

import java.util.List;

public class TeamDAO {

    public TeamsEntity buscarPorId(Integer id){

        EntityManager em= HibernateUtil.getEntityManger();
        TeamsEntity team = em.find(TeamsEntity.class,id);
        em.close();
        return team;
    }
    public List<TeamsEntity> listarEquipos(){

        EntityManager em=HibernateUtil.getEntityManger();
        List<TeamsEntity> lista=em.createQuery("FROM TeamsEntity ",TeamsEntity.class).getResultList();
        em.close();
        return lista;
    }
    public List<TeamsEntity> buscarPorNombre(String nombre){
        EntityManager em=HibernateUtil.getEntityManger();

        List<TeamsEntity> equipo=em.createQuery("FROM TeamsEntity t where t.name LIKE :nombre",TeamsEntity.class)
                .setParameter("nombre","%"+nombre+"%")
                .getResultList();
        em.close();

        return equipo;
    }

    public void guardarEquipo(TeamsEntity equipo){
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
    public void actualizarEquipo(TeamsEntity equipo){
        EntityManager em=HibernateUtil.getEntityManger();
        EntityTransaction tx= em.getTransaction();

        try {
            tx.begin();
            em.merge(equipo);
            tx.commit();
            System.out.println("Equipo actualizado: "+equipo.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        em.close();
    }
    public void borrarEquipo(Integer idEquipo){
        EntityManager em=HibernateUtil.getEntityManger();
        EntityTransaction tx= em.getTransaction();

        try {
            tx.begin();
            TeamsEntity equipo=em.find(TeamsEntity.class,idEquipo);
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
