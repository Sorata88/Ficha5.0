package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para realizar la conexión a la base de datos. Usando el patrón de diseño "Singleton" haremos uso de una única
 * instancia de la clase cada vez que la necesitemos.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class DBconnection {

    private static final String url = "jdbc:mysql://localhost:3306/dnd_ficha";
    private static final String user = "root";
    private static final String password = "1234+";
    private static Connection con=null;

    /**
     * Método para realizar la conexión a la base de datos.
     * @return devuelve el objeto de conexionado a la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    /**
     * Método para cerrar la conexión con la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static void closeConnection() throws SQLException {
        if(con!=null){
            con.close();
        }
    }


}
