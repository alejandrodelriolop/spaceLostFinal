package spaceLost;

import spaceLost.gestorJugador.Jugador;

public class JuegoOxigeno {

    private int oxigeno = 100;
    private Jugador jugador;

    public JuegoOxigeno(Jugador jugador) {
        this.jugador=jugador;
    }

    public int getOxigeno() {
        return oxigeno;
    }

    public void perderOxigeno(int cantidad) {
        oxigeno = Math.max(0, oxigeno - cantidad);
        mostrarOxigeno();
        comprobarMuerte();
    }

    public void ganarOxigeno(int cantidad) {
        oxigeno = Math.min(100, oxigeno + cantidad);
        mostrarOxigeno();
    }

    private void mostrarOxigeno() {
        System.out.println("Oxígeno: " + oxigeno + "%");
    }

    private void comprobarMuerte() {
        if (oxigeno <= 0) {
            System.out.println("💀 Te has quedado sin oxígeno...");
            System.exit(0);
        }
    }

}