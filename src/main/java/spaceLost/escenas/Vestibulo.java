package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.juego.JuegoOxigeno;
import spaceLost.gestorSalas.Sala;
import spaceLost.retos.Dados;

public class Vestibulo extends Sala{

    public Vestibulo(String nombre, String descripcion) {
        super(nombre, descripcion);

    }

    @Override
    public void ejecutar(Scanner sc, JuegoOxigeno juego) {

        System.out.println("\n🚪 VESTÍBULO PRINCIPAL");
        System.out.println(
            "Llegas al vestíbulo de la base.\n" +
            "Las luces parpadean y el silencio es inquietante.\n" +
            "Cuerpos sin vida cubren el suelo.\n" +
            "Entonces lo escuchas.\n" +
            "Un ruido húmedo, pesado… no es humano."
        );

        juego.perderOxigeno(5);

        System.out.println(
            "\nLa criatura te bloquea el paso.\n" +
            "Cada movimiento debe ser calculado.\n" +
            "La suerte decidirá si sobrevives."
        );

        new Dados().jugar(sc, juego);

        System.out.println(
            "\nLa criatura retrocede.\n" +
            "Aprovechas el momento y corres hacia los conductos de ventilación."
        );
    }
}
