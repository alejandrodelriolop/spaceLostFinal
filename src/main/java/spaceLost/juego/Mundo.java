package spaceLost.juego;

import spaceLost.escenas.*;
import spaceLost.gestorSalas.Sala;

public class Mundo {
    public static Sala crearMundo() {

        Sala almacen = new Almacen("Almacén", "Zona llena de cajas y polvo.");
        Sala vestibulo = new Vestibulo("Vestíbulo", "Entrada principal de la estación.");
        Sala conductos = new Conductos("Conductos", "Pasillos estrechos y oscuros.");
        Sala salaMandos = new SalaMandos("Sala de Mandos", "Paneles de control.");
        Sala nave = new NaveEscape("Nave", "La nave de escape está aquí.");

        almacen.conectarSala(vestibulo);
        vestibulo.conectarSala(conductos);
        conductos.conectarSala(salaMandos);
        salaMandos.conectarSala(nave);



        return almacen;
    }
}
