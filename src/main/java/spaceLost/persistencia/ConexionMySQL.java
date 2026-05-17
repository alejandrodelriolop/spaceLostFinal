package spaceLost.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {


    private static final String URL = "jdbc:mysql://localhost:3306/spaceLostMySQL";

    private static final String USER = "root";

    private static final String PASSWORD = "rootroot";

    public static Connection conectar() throws SQLException{

        return DriverManager.getConnection(
          URL, USER, PASSWORD
        );
    }

}
