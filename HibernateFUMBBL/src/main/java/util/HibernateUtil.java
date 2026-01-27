package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("fumbbl-unit");
            System.out.println("EntityManagerFactory creado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    public static EntityManager getEntityManger(){
        return emf.createEntityManager();
    }
    public static void close(){
        emf.close();
    }

}
