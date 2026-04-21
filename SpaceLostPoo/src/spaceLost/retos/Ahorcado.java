package spaceLost.retos;

import java.util.Scanner;
import spaceLost.JuegoOxigeno;

public class Ahorcado extends Reto {

    public Ahorcado() {
        super("Ahorcado");
    }

    @Override
    public void jugar(Scanner sc, JuegoOxigeno juego) {

        titulo();

        String[] palabras = { "ASTRONAUTA", "GALAXIA", "PLANETA", "NEBULOSA", "METEORITO" };
        String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];

        char[] progreso = new char[palabraSecreta.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        boolean juegoTerminado = false;
        String letrasUsadas = "";

        while (!juegoTerminado) {

            System.out.println("\nPalabra: " + String.valueOf(progreso));
            System.out.println("Oxígeno: " + juego.getOxigeno() + "%");
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.print("Ingresa una letra: ");

            String entrada = sc.nextLine().toUpperCase();

            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Introduce UNA letra válida.");
                continue;
            }

            char letra = entrada.charAt(0);

            if (letrasUsadas.indexOf(letra) != -1) {
                System.out.println("Ya has usado esa letra.");
                continue;
            }

            letrasUsadas += letra + " ";

            boolean letraEncontrada = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    progreso[i] = letra;
                    letraEncontrada = true;
                }
            }

            if (!letraEncontrada) {
                System.out.println("La letra no está en la palabra.");
                juego.perderOxigeno(5);
            }

            if (String.valueOf(progreso).equals(palabraSecreta)) {
                System.out.println("\n¡Ganaste! La palabra era: " + palabraSecreta);
                juego.ganarOxigeno(20);
                juegoTerminado = true;
            }
        }
    }
}