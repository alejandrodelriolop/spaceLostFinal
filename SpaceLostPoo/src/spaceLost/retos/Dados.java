package spaceLost.retos;

import java.util.Scanner;
import spaceLost.JuegoOxigeno;

public class Dados extends Reto {

    public Dados() {
        super("Duelo de Dados");
    }

    @Override
    public void jugar(Scanner sc, JuegoOxigeno juego) {
        titulo();

boolean ganarUsuario = false;
		int puntosJugador = 0;
		int puntosExtraterrestre = 0;

		do {
			
			int[] dadosJugador = tirarDados();
			int totalJugador = dadosJugador[0] + dadosJugador[1];
			System.out.println("Total del jugador: " + totalJugador);

			int[] dadosMaquina = tirarDados();
			int totalMaquina = dadosMaquina[0] + dadosMaquina[1];
			System.out.println("Total de la máquina: " + totalMaquina);

			// Comparación de resultados
		if (totalJugador > totalMaquina) {
    System.out.println("¡Ganaste!");
    puntosJugador++;

    if (puntosJugador == 3) {
        ganarUsuario = true;
        System.out.println("¡Felicidades! Has sobrevivido.");
        juego.ganarOxigeno(30);
    }

} else if (totalJugador < totalMaquina) {
    System.out.println("Perdiste.");
    puntosExtraterrestre++;

    if (puntosExtraterrestre == 3) {
        System.out.println("El extraterrestre gana esta ronda. Te has debilitado bastante");
        System.out.println("No me puedo permitir otro fallo");
        juego.perderOxigeno(10);
    }

} else {
    System.out.println("Empate.");
}


			System.out.println("\nPresiona ENTER para volver a tirar...");
			sc.nextLine();

		} while (!ganarUsuario); 
	}

	// Función que simula el lanzamiento de dos dados (valores del 1 al 6)
	public static int[] tirarDados() {
		int[] dados = new int[2];
		for (int i = 0; i < 2; i++)
			dados[i] = (int) (Math.random() * 6) + 1;

		System.out.println("Dado 1 = " + dados[0] + ", Dado 2 = " + dados[1]);
		return dados;
	}}