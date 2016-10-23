package main.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Klincaja on 21/10/16.
 * Clase de conexion a base de datos para consultas
 */
public class ConnectionDB {

    private final String STRINGCONNECTION = "jdbc:mysql://localhost:3306/cartelera?autoReconnect=true&useSSL=false";
    private Connection conexion;
    private final String USER = "root";
    private final String PASS = "klincaja123";
    private static ConnectionDB instance = null;

    private ConnectionDB() {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }*/
    }

    public static ConnectionDB getInstance() {
        if (instance == null)
            instance = new ConnectionDB();
        return instance;
    }

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection(STRINGCONNECTION, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error al intenta conectar Base de datos: " + e.getMessage());
        }
    }

    public void Desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al intentar desconectar Base de datos:" + e.getMessage());
        }
    }

}