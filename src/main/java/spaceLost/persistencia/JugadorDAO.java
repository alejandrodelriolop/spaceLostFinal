package spaceLost.persistencia;

import spaceLost.gestorJugador.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDAO {

    public void guardarJugador(Jugador jugador) {

        String sql = """
                INSERT INTO jugadores
                (nombre, sala_actual, puntuacion)
                VALUES(?,?,?)
                """;
        try (Connection con = ConexionMySQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, jugador.getNombre());

            ps.setString(2, jugador.getSalaActual());

            ps.setInt(3, jugador.getPuntuacion());

            ps.executeUpdate();

            System.out.println("Jugador guardado en MySQL");
        } catch (SQLException e) {
            System.out.println("Error al guardar jugador");
            e.printStackTrace();
        }

    }

    public Jugador buscarJugador(String nombre) {

        String sql = """
                SELECT * 
                FROM jugadores
                WHERE nombre = ?
                """;
        try (Connection con = ConexionMySQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,nombre);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Jugador(
                        rs.getString("nombre"),
                        rs.getString("sala_actual"),
                        rs.getInt("puntuacion")

                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarJugador(Jugador jugador) {

        String sql = """
                UPDATE INTO jugadores
                (nombre, sala_actual, puntuacion)
                VALUES(?,?,?)
                """;
        try (Connection con = ConexionMySQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, jugador.getNombre());

            ps.setString(2, jugador.getSalaActual());

            ps.setInt(3, jugador.getPuntuacion());

            ps.executeUpdate();

            System.out.println("Jugador actualizado en MySQL");
        } catch (SQLException e) {
            System.out.println("Error al actualizar jugador");
            e.printStackTrace();
        }

    }

}