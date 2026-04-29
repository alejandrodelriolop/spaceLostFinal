package spaceLost;

import java.util.Scanner;
import spaceLost.excepciones.EntradaInvalidaException;

public class LectorConsola {

    public static int leerOpcionMenu(Scanner sc)
            throws EntradaInvalidaException {

        String entrada = sc.nextLine();

        if (entrada.isBlank()) {
            throw new EntradaInvalidaException(
                    "No puedes dejar el campo vacío.");
        }

        int numero;

        try {
            numero = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException(
                    "Debes introducir un número.");
        }

        return numero;
    }
}