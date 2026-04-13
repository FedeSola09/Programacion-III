package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private static final String user = "root";
    private static final String password = "Pancho09.";
    private static final String db_name = "alumnos";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/";

    public static Connection crearConexion() {
        try {
            return DriverManager.getConnection(url + db_name, user, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar: \n" + e.getMessage());
            return null;
        }
    }
}

