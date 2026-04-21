package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.JuegoOxigeno;
import spaceLost.Sala;
import spaceLost.retos.TresEnRaya;

public class SalaMandos extends Sala {

    public SalaMandos(String nombre, String descripcion) {
        super(nombre, descripcion);
       
    }

    @Override
    public void ejecutar(Scanner sc, JuegoOxigeno juego) {

        System.out.println("\n🧭 SALA DE MANDOS");
        System.out.println(
            "Llegas a la sala de mandos.\n" +
            "Las pantallas muestran imágenes caóticas de la base.\n" +
            "Los sistemas están fallando.\n" +
            "Solo queda una nave de escape operativa."
        );

        juego.perderOxigeno(10);

        System.out.println(
            "\nEl ascensor no responde.\n" +
            "El problema está en el panel eléctrico.\n" +
            "Los cables no hacen contacto.\n" +
            "Necesitas que todo encaje a la perfección… aunque solo sea un segundo."
        );

        new TresEnRaya().jugar(sc, juego);

        System.out.println(
            "\nLas luces se estabilizan.\n" +
            "El sistema responde.\n" +
            "Las puertas del ascensor se abren.\n" +
            "La nave de escape te espera."
        );
    }
}
