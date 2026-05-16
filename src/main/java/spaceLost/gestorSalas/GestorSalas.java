package spaceLost.gestorSalas;

import java.util.HashMap;
import java.util.Map;

public class GestorSalas {

    private Map<String, Sala> salas = new HashMap<>();

    public void agregarSala(Sala sala) {
        salas.put(sala.getNombre(), sala);
    }

    public Sala getSala(String nombre) {
        return salas.get(nombre);
    }
}