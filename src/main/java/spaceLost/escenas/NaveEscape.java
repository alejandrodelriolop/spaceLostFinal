package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.juego.JuegoOxigeno;
import spaceLost.gestorSalas.Sala;

public class NaveEscape extends Sala {

    public NaveEscape(String nombre, String descripcion) {
        super(nombre, descripcion);
       
    }

    @Override
    public void ejecutar(Scanner sc, JuegoOxigeno juego) {
        System.out.println("Arrancas la nave.");
        System.out.println(
                "Una vez dentro de la nave ya te sientes más seguro, arrancas y parece que pronto estarás en la estación internacional ");
        System.out.println(
                "Avanzas unos metros, pero nuestro \"amigo\" aparece...muy fácil había sido librarnos de ¿él?");
        System.out.println("Ves que se acerca a tí por la derecha, tienes que tomar una decisión rápida");
        System.out.println("¿Hacía que lado vamos(izquierda/derecha)");

        String comando = sc.nextLine().toLowerCase();

        if (comando.equals("izquierda")) {
            System.out.println("¡Te salvaste! 🚀🎉");
            System.out.println("Ha estado cerca, creo que cuando pise la tierra no volveré ni a coger un avión");
            System.out.println("Voy a comunicarme con la estación para aisar de mi situación");
            System.out.println("Tras varios mimutos hay señal pero no respuesta...");
            System.out.println("¿FIN?");
            System.exit(0);
        } else if (comando.equals("derecha")) {
            System.out.println("El extraterrestre agarra la nave y trunca los motores");
            System.out.println("En cuestión de segundos está en la cabina");
            System.out.println("Tan cerca y tan lejos de la salvación");
            juego.perderOxigeno(100);
        } else {
            System.out.println("Comando inválido.");
        }

    }
}