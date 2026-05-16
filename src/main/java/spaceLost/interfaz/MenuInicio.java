package spaceLost.interfaz;

import spaceLost.excepciones.EntradaInvalidaException;
import spaceLost.gestorJugador.GestorJugadores;
import spaceLost.gestorJugador.Jugador;
import spaceLost.persistencia.JugadorDAO;

import javax.swing.*;
import java.awt.*;

public class MenuInicio extends JFrame {

    private GestorJugadores gestor;

    private JTextField campoNombre;
    private JButton botonEntrar;

    public MenuInicio(){

        gestor= new GestorJugadores();

        setTitle("Space Lost");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        inicializarComponentes();

        setVisible(true);
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JLabel titulo = new JLabel("Introduce tu nombre", SwingConstants.CENTER);

        campoNombre = new JTextField();

        botonEntrar = new JButton("Entrar");

        botonEntrar.addActionListener(e-> {
            try {
                iniciarJuego();
            } catch (EntradaInvalidaException ex) {
                throw new RuntimeException(ex);
            }
        });

        panel.add(titulo);
        panel.add(campoNombre);
        panel.add(botonEntrar);
        add(panel);
    }



    private void iniciarJuego() throws EntradaInvalidaException {

        String nombre = campoNombre.getText().trim();

        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(
                    this,"Introduce un nombre válido"
            );
            return;
        }


        Jugador jugador = gestor.addJugador(nombre);

        JugadorDAO dao = new JugadorDAO();

        Jugador jugadorMySQL = dao.buscarJugador(nombre);

        if(jugadorMySQL== null){
            dao.guardarJugador(jugador);
        }

        dispose();

        new MenuPrincipal(jugador, gestor);

    }
}
