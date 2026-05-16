package spaceLost.interfaz;

import spaceLost.excepciones.EntradaInvalidaException;
import spaceLost.gestorJugador.GestorJugadores;
import spaceLost.gestorJugador.Jugador;
import spaceLost.gestorSalas.Sala;
import spaceLost.juego.ControladorJuego;
import spaceLost.juego.JuegoOxigeno;
import spaceLost.juego.Mundo;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

    public class MenuPrincipal extends JFrame {

        private Jugador jugador;

        private GestorJugadores gestor;

        public MenuPrincipal(Jugador jugador,
                             GestorJugadores gestor) {

            this.jugador = jugador;
            this.gestor = gestor;

            setTitle("Menú Principal");

            setSize(400,300);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setLocationRelativeTo(null);

            inicializarComponentes();

            setVisible(true);
        }

        private void inicializarComponentes() {

            JPanel panel = new JPanel();

            panel.setLayout(new GridLayout(4,1,10,10));

            JButton iniciar = new JButton("Iniciar juego");

            JButton instrucciones =
                    new JButton("Instrucciones");

            JButton creditos =
                    new JButton("Créditos");

            JButton salir =
                    new JButton("Salir");

            iniciar.addActionListener(e -> {
                try {
                    iniciarJuego();
                } catch (EntradaInvalidaException ex) {
                    throw new RuntimeException(ex);
                }
            });

            instrucciones.addActionListener(e ->
                    mostrarInstrucciones());

            creditos.addActionListener(e ->
                    mostrarCreditos());

            salir.addActionListener(e ->
                    System.exit(0));

            panel.add(iniciar);

            panel.add(instrucciones);

            panel.add(creditos);

            panel.add(salir);

            add(panel);
        }

        private void iniciarJuego() throws EntradaInvalidaException {

            Sala salaInicial = Mundo.crearMundo();

            JuegoOxigeno juego =
                    new JuegoOxigeno(jugador);

            ControladorJuego controlador =
                    new ControladorJuego(
                            jugador,
                            salaInicial,
                            juego,
                            gestor
                    );

            dispose();

            controlador.iniciar(new Scanner(System.in));
        }

        private void mostrarInstrucciones() {

            JOptionPane.showMessageDialog(
                    this,
                    "Debes escapar antes de quedarte sin oxígeno."
            );
        }

        private void mostrarCreditos() {

            JOptionPane.showMessageDialog(
                    this,
                    "Juego creado por Alejandro del Río López"
            );

    }
}
