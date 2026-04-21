package spaceLost.retos;

import java.util.Random;
import java.util.Scanner;
import spaceLost.JuegoOxigeno;

public class TresEnRaya extends Reto {

    public TresEnRaya() {
        super("Tres en Raya");
    }

    @Override
    public void jugar(Scanner sc, JuegoOxigeno juego) {
        titulo();

        boolean ganarUsuario = false;

        // Se repite la partida hasta que el usuario gane
        do {
            // Inicialización del tablero vacío
            char[][] tablero = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

            boolean turnoJugador = true; //
            boolean partidaTerminada = false;

            while (!partidaTerminada) {
                imprimirTablero(tablero);

                // Turno del jugador o de la máquina
                if (turnoJugador) {
                    turnoHumano(tablero, sc);
                } else {
                    turnoMaquina(tablero);
                }

                // Verificar si el jugador ganó
                if (hayGanador(tablero, 'X')) {
                    imprimirTablero(tablero);
                    System.out.println("Lo conseguiste, ya puedes abrir la compuerta");

                    // Recupera oxígeno (máx. 100)
                    juego.ganarOxigeno(20);
                    ganarUsuario = true;
                    partidaTerminada = true;

                    // Verificar si la máquina ganó
                } else if (hayGanador(tablero, '0')) {
                    imprimirTablero(tablero);
                    System.out.println("No has conseguido conectar los cables, prueba de nuevo");

                    juego.perderOxigeno(20);
                    ganarUsuario = false;
                    partidaTerminada = true;

                    // Verificar empate (tablero lleno)
                } else if (tableroLleno(tablero)) {
                    imprimirTablero(tablero);
                    System.out.println("Empate. Prueba otra vez");
                    ganarUsuario = false;
                    partidaTerminada = true;
                }

                // Cambiar turno si la partida continúa
                if (!partidaTerminada) {
                    turnoJugador = !turnoJugador;
                }
            }

        } while (!ganarUsuario); 
    }


    public static void imprimirTablero(char[][] tablero) {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2] + " |");
            if (i < 2)
                System.out.println(" ------------");
        }
        System.out.println();
    }

    // Turno del jugador humano
    public static void turnoHumano(char[][] tablero, Scanner sc) {
        int fila;
        int columna;

        while (true) {
            System.out.print("Ingresa fila(0-2): ");
            fila = sc.nextInt();
            System.out.print("Ingresa columna(0-2): ");
            columna = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            // Verifica que la posición esté dentro del tablero y libre
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = 'X';
                break;
            } else {
                System.out.println("Movimiento inválido. Prueba de nuevo");
            }
        }
    }

    // Turno de la máquina
    public static void turnoMaquina(char[][] tablero) {
        System.out.println("Turno de la máquina");

        // 1. Intenta ganar si hay una jugada posible
        int[] jugada = buscarMejorMovimiento(tablero, '0');
        if (jugada != null) {
            tablero[jugada[0]][jugada[1]] = '0';
            return;
        }

        // 2. Si no puede ganar, intenta bloquear al jugador
        jugada = buscarMejorMovimiento(tablero, 'X');
        if (jugada != null) {
            tablero[jugada[0]][jugada[1]] = '0';
            return;
        }

        // 3. Si no hay jugadas críticas, elige una casilla aleatoria libre
        Random r = new Random();
        int fila, columna;

        do {
            fila = r.nextInt(3);
            columna = r.nextInt(3);
        } while (tablero[fila][columna] != ' ');

        tablero[fila][columna] = '0';
    }

    // Busca si hay un movimiento ganador o bloqueador para el jugador dado
    public static int[] buscarMejorMovimiento(char[][] tablero, char jugador) {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)

                // Si la casilla está libre, la prueba temporalmente
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = jugador;

                    // Si genera una victoria, esa jugada es la mejor
                    if (hayGanador(tablero, jugador)) {
                        tablero[i][j] = ' ';
                        return new int[] { i, j };
                    }

                    // Si no, revierte el movimiento
                    tablero[i][j] = ' ';
                }

        return null; // No hay jugadas ganadoras o bloqueadoras
    }

    // Comprueba si un jugador ha ganado
    public static boolean hayGanador(char[][] tablero, char jugador) {

        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador)
                return true;

            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)
                return true;
        }

        // Revisar diagonales
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador)
            return true;

        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)
            return true;

        return false;
    }

    // Comprueba si ya no quedan casillas vacías
    public static boolean tableroLleno(char[][] tablero) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ')
                    return false;

        return true;
    }
}