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

        if (numero != 0 && numero != 1 && numero != 9) {
            throw new EntradaInvalidaException(
                    "Solo puedes introducir 0 (Salir), 1 (Moverte) o 9 (Volver atrás).");
        }

        return numero;
    }
}