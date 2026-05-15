package spaceLost.gestorJugador;

import java.util.Map;
import java.io.*;
import java.util.HashMap;

public class GestorJugadores {

        private  Map<String, Jugador> jugadores;
        private final String RUTA_FICHERO = "jugadores.txt";

        public GestorJugadores() {
            jugadores = new HashMap<>();
            cargarJugadores();
        }

        public Jugador addJugador(String nombre) {
            if (jugadores.containsKey(nombre)) {
                return jugadores.get(nombre);
            }

            Jugador nuevo = new Jugador(nombre);
            jugadores.put(nombre, nuevo);
            guardarTodos(); // evita duplicados
            return nuevo;
        }

        private void cargarJugadores() {
            File fichero = new File(RUTA_FICHERO);

            if (!fichero.exists()) return;

            try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");

                    if (partes.length == 3) {
                        String nombre = partes[0];
                        String sala = partes[1];
                        int puntuacion = Integer.parseInt(partes[2]);

                        Jugador j = new Jugador(nombre, sala, puntuacion);
                        jugadores.put(nombre, j);
                    }
                }

            } catch (IOException e) {
                System.out.println("Error al cargar jugadores");
            }
        }

        public void guardarTodos() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_FICHERO))) {

                for (Jugador j : jugadores.values()) {
                    bw.write(j.toString());
                    bw.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error al guardar jugadores");
            }
        }

        public Jugador getJugador(String nombre) {

            return jugadores.get(nombre);
        }
    }
