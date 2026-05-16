package spaceLost.gestorJugador;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Jugador {

    private String nombre;
    private String salaActual;
    private int puntuacion;
    private Set<String> salasVisitadas = new HashSet<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salaActual = "Inicio"; // nombre de la sala inicial
        this.puntuacion = 0;
    }

    public Jugador(String nombre, String salaActual, int puntuacion) {
        this.nombre = nombre;
        this.salaActual = salaActual;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalaActual() {
        return salaActual;
    }

    public void setSalaActual(String salaActual) {
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

    public Collection<String> getSalasVisitadas() {
        return salasVisitadas;
    }
}
