package spaceLost;


import java.util.ArrayList;
import java.util.Scanner;

import spaceLost.gestorJugador.Jugador;
import spaceLost.escenas.Escena;

public abstract class Sala implements Escena {

    private boolean visitada=false;
    private String nombre;
    private String descripcion;
    private ArrayList<Sala> conexiones;
    private ArrayList<Objeto> objetos;
    private Objeto objetoRequerido; // null si no requiere nada


    public Sala(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.conexiones = new ArrayList<>();
        this.objetos = new ArrayList<>();
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

        if (!objetos.isEmpty()) {
            System.out.println("Objetos en la sala: " + objetos);
        }

        System.out.println("\nConexiones:");
        for (int i = 0; i < conexiones.size(); i++) {
            System.out.println((i + 1) + ". " + conexiones.get(i).getNombre());
        }
    }

public Sala irA(int opcion, Jugador jugador) {

    if (opcion <= 0 || opcion > conexiones.size())
        return this;

    Sala destino = conexiones.get(opcion - 1);


    return destino;
}

    public ArrayList<Objeto> recogerObjetos() {
        ArrayList<Objeto> recogidos = new ArrayList<>(objetos);
        objetos.clear();
        return recogidos;
    }



public void entrar(Jugador jugador, Scanner sc, JuegoOxigeno juego) {

    if (!visitada) {
        ejecutar(sc, juego);  // aquí cada subclase tendrá su minijuego
        visitada = true;
    }


}





}