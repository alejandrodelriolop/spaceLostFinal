package spaceLost.Entidad;


public class Enemigo extends Entidad {

    private int ataque;

    public Enemigo(String nombre, int vida, int ataque) {
        super(nombre, vida);
        this.ataque = ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void atacar(Jugador jugador) {
        System.out.println(nombre + " ataca!");
        jugador.recibirDanio(ataque);
    }

    @Override
    public void actuar() {
        System.out.println(nombre + " vigila la zona...");
    }
}