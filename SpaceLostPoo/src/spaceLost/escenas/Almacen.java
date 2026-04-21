package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.JuegoOxigeno;
import spaceLost.Sala;
import spaceLost.retos.Ahorcado;

public class Almacen extends Sala {

    public Almacen(String nombre, String descripcion) {
        super(nombre, descripcion);

    }

    @Override
    public void ejecutar(Scanner sc, JuegoOxigeno juego) {

        System.out.println("Año 2050.\n" + //
                "Formas parte de la primera misión humana destinada a establecer una colonia permanente en Marte.\n" + //
                "Mientras revisas el material para una salida a la superficie, una explosión sacude la base.\n" + //
                "Algo cae del techo y pierdes el conocimiento.\n" + //
                "\n" + //
                "Cuando despiertas, las alarmas suenan sin parar.\n" + //
                "El aire es cada vez más escaso.\n" + //
                "Estás solo...");
        System.out.println("Te encuentras en el almacén de la base.\n" + //
                "La sensación de ahogo aumenta.\n" + //
                "Sabes que necesitas un traje de expedición, pero el armario está protegido por un código.\n" + //
                "");
        juego.perderOxigeno(10);

        while (true) {
            System.out.println("“El capitán siempre decía que era la respuesta a todo…”");
            System.out.print("Código del armario: ");
            try {
                int codigo = Integer.parseInt(sc.nextLine());
                
                if (codigo < 0) {
                    System.out.println("El código no puede ser negativo.");
                    continue;
                }

                if (codigo == 42) {
                    System.out.println("Código correcto. Traje equipado.");
                    juego.ganarOxigeno(100);
                    break;
                } else {
                    juego.perderOxigeno(10);
                    System.out.println(codigo > 42 ? "El número es menor" : "El número es mayor");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un número");

            }}
        
            System.out.println(
                    "\nMucho mejor... parece que empiezo a respirar de manera normal, pero la botella tampoco es infinita...");
            System.out.println("Ahora debo salir de aquí y averiguar que está pasando, aunque no tiene buena pinta");
            System.out.println(
                    "Te acercas a la salida y encuentras que hay que introducir otro código, lo que te faltaba");
            System.out.println("Pista: mira al cielo");

            new Ahorcado().jugar(sc, juego);
        }
    }
