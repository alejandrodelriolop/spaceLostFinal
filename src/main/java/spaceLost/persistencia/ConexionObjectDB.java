package spaceLost.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionObjectDB {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("spaceLostDB");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

}
