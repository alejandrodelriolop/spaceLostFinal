package spaceLost.retos;

public abstract class Reto implements Jugable {

    protected String nombre;

    public Reto(String nombre) {
        this.nombre = nombre;
    }

    protected void titulo() {
        System.out.println("\n=== " + nombre + " ===");
    }
}