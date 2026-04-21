package spaceLost.Entidad;

import java.util.ArrayList;

import spaceLost.Objeto;

public class Jugador extends Entidad {

    private ArrayList<Objeto> inventario;

    public Jugador(String nombre) {
        super(nombre, 100);
        inventario = new ArrayList<>();
    }

    public void agregarObjetos(ArrayList<Objeto> objetos) {
        inventario.addAll(objetos);
    }

    public boolean tieneObjeto(Objeto obj) {
        return inventario.contains(obj);
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }

    public void mostrarInventario() {
        System.out.println("Inventario: " + inventario);
    }

    @Override
    public void actuar() {
        System.out.println(nombre + " está listo para actuar.");
    }

}