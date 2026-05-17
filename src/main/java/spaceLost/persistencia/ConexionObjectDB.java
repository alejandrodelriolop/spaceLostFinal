package spaceLost.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionObjectDB {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("spaceLostDB");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

}
