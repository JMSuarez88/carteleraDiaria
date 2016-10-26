package databaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Klincaja on 21/10/16.
 * Clase de conexion a base de datos para consultas
 */
public class ConnectionDB {

    private final String STRINGCONNECTION = "jdbc:mysql://localhost:3306/carteleradiaria?autoReconnect=true&useSSL=false";
    private Connection conexion;
    private final String USER = "root";
    private final String PASS = "klincaja123";
    private static ConnectionDB instance = null;

    private ConnectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
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

    public int crearMateria(String nombre,int codigo,ArrayList<String> tagArrayList){
        try
        {
            Conectar();
            Statement s = conexion.createStatement();
            int rs = s.executeUpdate("insert into materia (nombre,codigo,tag) values('"+nombre+"',"+codigo+",'"+arrayListToJsonString(tagArrayList)+"');");
        }catch(SQLException ex){
            System.out.println("Error al crear materia :"+ex.getMessage());
        }finally{
            Desconectar();
        }
        return 0;
    }

    public String arrayListToJsonString(ArrayList<String> cursadas) {
        /*JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        for (String s:cursadas) {
            array.add(s);
        }
        try {
            json.put("tags", array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());
        return json.toString();
        */
        String aux = "";
        for (String s:cursadas) {
            aux = aux+s+",";
        }
        if(aux.length()>0){
            aux = aux.substring(0,aux.length()-1);
        }
        return aux;
    }

}