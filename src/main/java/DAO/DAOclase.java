package DAO;

import modelo.Clase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Objet) de la clase "clase". Permite encapsular toda la lógica de acceso a datos del resto de
 * la aplicación.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class DAOclase {

    private Connection conn = null;
    private static DAOclase instance = null;

    /**
     * Método que nos permite conectarnos a la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public DAOclase() throws SQLException {
        conn = DBconnection.getConnection();
    }

    /**
     * Método que implementa el patrón de diseño "Singleton" para la clase "clase". Sólo permite una instancia de la
     * clase para toda la aplicación. Si no existe, creará el objeto, en caso contrario, lo invocará desde la memoria.
     * @return devuelve el objeto DAO de la clase "clase".
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static DAOclase getInstance() throws SQLException {
        if (instance == null) {
            instance = new DAOclase();
        }
        return instance;
    }

    /**
     * Método para recuperar un objeto de tipo "clase" de la base de datos en función de su atributo nombre (único).
     * @param nombre atributo que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo "clase" deseado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public Clase listarClase(String nombre) throws SQLException {
        String query = "SELECT * FROM clase WHERE nombre=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Clase clase = new Clase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        return clase;
    }

}
