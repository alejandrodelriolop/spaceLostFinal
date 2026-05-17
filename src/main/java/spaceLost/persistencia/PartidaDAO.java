package spaceLost.persistencia;

import javax.persistence.EntityManager;
import spaceLost.gestorJugador.Jugador;

public class PartidaDAO {

    public void guardarPartida(Jugador jugador){

        EntityManager em = ConexionObjectDB.getEntityManager();

        em.getTransaction().begin();

        em.merge(jugador);

        em.getTransaction().commit();

        em.close();

        System.out.println("Partida guardad en ObjectDB");
    }
}
