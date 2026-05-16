package spaceLost.juego;

import spaceLost.excepciones.EntradaInvalidaException;
import spaceLost.gestorSalas.Sala;

import spaceLost.gestorJugador.GestorJugadores;
import spaceLost.gestorJugador.Jugador;
import spaceLost.persistencia.JugadorDAO;
import spaceLost.utilidades.LectorConsola;

import java.util.ArrayList;
import java.util.Scanner;

    public class ControladorJuego {

        private Jugador jugador;
        private JugadorDAO dao;
        private Sala salaActual;


        private JuegoOxigeno juego;
        private GestorJugadores gestor;

        private ArrayList<Sala> historial;

        public ControladorJuego(Jugador jugador,
                                Sala salaInicial,
                                JuegoOxigeno juego,
                                GestorJugadores gestor) {

            this.jugador = jugador;
            this.salaActual = salaInicial;
            this.juego = juego;
            this.gestor = gestor;
            dao = new JugadorDAO();

            historial = new ArrayList<>();
        }

        public void iniciar(Scanner sc) throws EntradaInvalidaException {

            boolean salir = false;

            while (!salir) {

                salaActual.entrar(jugador, sc, juego);

                salaActual.mostrarInfo();

                System.out.println("9. Volver atrás");
                System.out.println("0. Salir");

                int opcion = LectorConsola.leerOpcionMenu(sc);

                if (opcion == 0) {

                    salir = true;

                }
                else if (opcion == 9 && !historial.isEmpty()) {

                    salaActual = historial.remove(historial.size() - 1);

                }
                else {

                    Sala nuevaSala = salaActual.irA(opcion);

                    if (nuevaSala != salaActual) {

                        historial.add(salaActual);

                        salaActual = nuevaSala;

                        jugador.setSalaActual(salaActual.getNombre());
                    }
                }

                gestor.guardarTodos();
                dao.actualizarJugador(jugador);

            }
        }
    }
