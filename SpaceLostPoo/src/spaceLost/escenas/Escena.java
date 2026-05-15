package spaceLost.escenas;

import java.util.Scanner;
import spaceLost.juego.JuegoOxigeno;

public interface Escena {

    
    public abstract void ejecutar(Scanner sc, JuegoOxigeno juego);

   
}