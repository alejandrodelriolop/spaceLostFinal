package spaceLost;

import java.util.ArrayList;
import java.util.Scanner;
import spaceLost.gestorJugador.GestorJugadores;
import spaceLost.gestorJugador.Jugador;


import spaceLost.gestorJugador.Jugador;
import spaceLost.escenas.*;
import spaceLost.excepciones.EntradaInvalidaException;
import spaceLost.excepciones.OpcionInvalidaException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Sala salaInicial = crearMundo();
        Jugador jugador = new Jugador("Explorador");
        JuegoOxigeno juego = new JuegoOxigeno(jugador);
        ejecutarMenu(sc, jugador, salaInicial, juego);

        sc.close();
    }

    // ====================== MENÚ ======================

    private static void ejecutarMenu(Scanner sc, Jugador jugador, Sala salaInicial, JuegoOxigeno juego) {

        int opcion;

        do {

            mostrarMenu();

            try {

                opcion = leerOpcion(sc);
                procesarOpcion(opcion, sc, jugador, salaInicial, juego);

            } catch (OpcionInvalidaException e) {

                System.out.println("\n⚠️ Error: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ ALONE IN MARS ===");
        System.out.println("1. Ver instrucciones");
        System.out.println("2. Iniciar juego");
        System.out.println("3. Créditos");
        System.out.println("4. Salir");
        System.out.print("\nElige una opción: ");
    }

    private static void procesarOpcion(int opcion, Scanner sc,
            Jugador jugador, Sala salaInicial, JuegoOxigeno juego) {

        switch (opcion) {

            case 1:
                mostrarInstrucciones();
                break;

            case 2:
                ejecutarJuego(sc, jugador, salaInicial, juego);

                break;

            case 3:
                mostrarCreditos();
                break;

            case 4:
                salir();
                break;
        }
    }

    private static void mostrarInstrucciones() {
        System.out.println(
                "\n📜 Instrucciones: Debes escapar antes de que se acabe el oxígeno o te atrapen...");
    }

    private static void mostrarCreditos() {
        System.out.println(
                "\n🎬 Créditos: Escape Room creado por Alejandro del Río López - DAM1V");
    }

    private static void salir() {
        System.out.println("\n👋 Saliendo del programa... ¡Hasta pronto!");
    }

    private static int leerOpcion(Scanner sc) throws OpcionInvalidaException {

        try {

            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion < 1 || opcion > 4) {
                throw new OpcionInvalidaException("La opción debe estar entre 1 y 4.");
            }

            return opcion;

        } catch (NumberFormatException e) {
            throw new OpcionInvalidaException("Debes introducir un número válido.");
        }
    }

    // ====================== JUEGO ======================

    private static Sala crearMundo() {

        Sala almacen = new Almacen("Almacén", "Zona llena de cajas y polvo.");
        Sala vestibulo = new Vestibulo("Vestíbulo", "Entrada principal de la estación.");
        Sala conductos = new Conductos("Conductos", "Pasillos estrechos y oscuros.");
        Sala salaMandos = new SalaMandos("Sala de Mandos", "Paneles de control.");
        Sala nave = new NaveEscape("Nave", "La nave de escape está aquí.");

        almacen.conectarSala(vestibulo);
        vestibulo.conectarSala(conductos);
        conductos.conectarSala(salaMandos);
        salaMandos.conectarSala(nave);



        return almacen;
    }


    private static void ejecutarJuego(Scanner sc, Jugador jugador, Sala salaInicial, JuegoOxigeno juego) {

        Sala salaActual = salaInicial;
        ArrayList<Sala> historial = new ArrayList<>();
        boolean salir = false;

        while (!salir) {

            salaActual.entrar(jugador, sc, juego);

            salaActual.mostrarInfo();
            System.out.println("9. Volver atrás");
            System.out.println("0. Salir");

            int opcion;


            try {
                opcion = LectorConsola.leerOpcionMenu(sc);
            } catch (EntradaInvalidaException e) {
                System.out.println("⚠️ " + e.getMessage());
                continue;
            }
            if (opcion == 0) {
                salir = true;
            } else if (opcion == 9 && !historial.isEmpty()) {
                salaActual = historial.remove(historial.size() - 1);
            } else {
                Sala nuevaSala = salaActual.irA(opcion, jugador);
                if (nuevaSala != salaActual) {
                    historial.add(salaActual);
                    salaActual = nuevaSala;
                }
            }
        }
    }
}