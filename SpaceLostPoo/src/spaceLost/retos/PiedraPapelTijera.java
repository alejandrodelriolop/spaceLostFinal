package spaceLost.retos;

import java.util.Random;
import java.util.Scanner;
import spaceLost.JuegoOxigeno;

public class PiedraPapelTijera extends Reto {

    public PiedraPapelTijera() {
        super("Piedra Papel Tijera");
    }

    @Override
    public void jugar(Scanner sc, JuegoOxigeno juego) {
        titulo();
        Random random = new Random();
        String[] opciones = { "piedra", "papel", "tijera" };
        boolean ganarUsuario = false;
        do {

            System.out.print("\nElige piedra, papel o tijera: ");
            String jugador = sc.nextLine().toLowerCase();

            if (!jugador.equals("piedra") && !jugador.equals("papel") && !jugador.equals("tijera")) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                continue;
            }

            String hermano = opciones[random.nextInt(3)];
            System.out.println("Tu hermano eligió " + hermano);

            // Comparación de elecciones
            if (jugador.equals(hermano)) {

                System.out.println("¡Empate! Sigue jugando...");
                juego.perderOxigeno(5);

            } else if (

            (jugador.equals("piedra") && hermano.equals("tijera"))
                    || (jugador.equals("papel") && hermano.equals("piedra"))
                    || (jugador.equals("tijera") && hermano.equals("papel"))) {
                System.out.println("¡Ganaste!");
                ganarUsuario = true;

                juego.ganarOxigeno(10);

            } else {

                System.out.println("Hermanito eres muy malo. Prueba otra vez");

                juego.perderOxigeno(10);
            }

        } while (!ganarUsuario);
    }
}