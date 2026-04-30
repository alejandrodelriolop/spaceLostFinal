package spaceLost.Entidad;

import java.util.ArrayList;

import spaceLost.Objeto;

public class Jugador {

        private String nombre;
        private int salaActual;
        private int puntuacion;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.salaActual = 1;
            this.puntuacion = 0;
        }

        public Jugador(String nombre, int salaActual, int puntuacion) {
            this.nombre = nombre;
            this.salaActual = salaActual;
            this.puntuacion = puntuacion;
        }

        public String getNombre() {
            return nombre;
        }

        public int getSalaActual() {
            return salaActual;
        }

        public void setSalaActual(int salaActual) {
            this.salaActual = salaActual;
        }

        public int getPuntuacion() {
            return puntuacion;
        }

        public void setPuntuacion(int puntuacion) {
            this.puntuacion = puntuacion;
        }

        @Override
        public String toString() {
            return nombre + ";" + salaActual + ";" + puntuacion;
        }
    }