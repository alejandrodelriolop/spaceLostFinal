package spaceLost.gestorSalas;


import java.util.ArrayList;
import java.util.Scanner;

import spaceLost.juego.JuegoOxigeno;
import spaceLost.gestorJugador.Jugador;
import spaceLost.escenas.Escena;

public abstract class Sala implements Escena {


        private boolean visitada = false;
        private String nombre;
        private String descripcion;
        private ArrayList<Sala> conexiones;

        public Sala(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.conexiones = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public void conectarSala(Sala sala) {
            if (!conexiones.contains(sala)) {
                conexiones.add(sala);
                sala.conectarSala(this);
            }
        }

        public void mostrarInfo() {
            System.out.println("\n=== " + nombre + " ===");
            System.out.println(descripcion);

            System.out.println("\nConexiones:");
            for (int i = 0; i < conexiones.size(); i++) {
                System.out.println((i + 1) + ". " + conexiones.get(i).getNombre());
            }
        }

        public Sala irA(int opcion) {

            if (opcion <= 0 || opcion > conexiones.size())
                return this;

            return conexiones.get(opcion - 1);
        }

        public void entrar(Jugador jugador, Scanner sc, JuegoOxigeno juego) {

            // CLAVE: guardar progreso
            jugador.setSalaActual(nombre);
            jugador.getSalasVisitadas().add(nombre);
            if (!visitada) {
                ejecutar(sc, juego);
                visitada = true;

                // opcional: recompensa
                jugador.setPuntuacion(jugador.getPuntuacion() + 50);
            }
        }

        // cada sala implementa su minijuego
        public abstract void ejecutar(Scanner sc, JuegoOxigeno juego);
    }