package spaceLost.Entidad;

public abstract class Entidad {

    protected String nombre;
    protected int vida;

    public Entidad(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) vida = 0;
    }

    public abstract void actuar();
}