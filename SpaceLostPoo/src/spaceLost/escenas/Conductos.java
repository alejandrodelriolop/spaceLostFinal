package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.JuegoOxigeno;
import spaceLost.gestorSalas.Sala;
import spaceLost.retos.PiedraPapelTijera;

public class Conductos extends Sala {

    public Conductos(String nombre, String descripcion) {
        super(nombre, descripcion);
      
    }

    @Override
    public void ejecutar(Scanner sc, JuegoOxigeno juego) {

        System.out.println("\n🌫️ CONDUCTOS DE VENTILACIÓN");
        System.out.println(
            "Te arrastras por los conductos de ventilación.\n" +
            "El aire es denso y cada respiración cuesta más.\n" +
            "La falta de oxígeno empieza a afectar a tu mente."
        );

        juego.perderOxigeno(15);

        System.out.println(
            "\nDe repente, todo cambia.\n" +
            "Estás en casa...ese lugar ya no existe.\n" +
            "Tu hermano te mira y sonríe.\n" +
            "— Juega conmigo —dice.\n" +
            "Sabes que es un sueño.\n" +
            "Si no despiertas ahora, no despertarás nunca."
        );

        new PiedraPapelTijera().jugar(sc, juego);

        System.out.println(
            "\nAbres los ojos sobresaltado.\n" +
            "Sigues en los conductos.\n" +
            "Al fondo, una rejilla caliente indica la salida hacia la sala de mandos."
        );
    }
}
