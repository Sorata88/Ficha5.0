package DAO;

import modelo.Raza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Objet) de la clase raza. Permite encapsular toda la lógica de acceso a datos del resto de
 * la aplicación.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class DAOraza {

    private Connection conn = null;
    private static DAOraza instance = null;

    /**
     * Método que nos permite conectarnos a la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public DAOraza() throws SQLException {
        conn = DBconnection.getConnection();
    }

    /**
     * Método que implementa el patrón de diseño "Singleton" para la clase raza. Sólo permite una instancia de la
     * clase para toda la aplicación. Si no existe, creará el objeto, en caso contrario, lo invocará desde la memoria.
     * @return  devuelve el objeto DAO de la clase raza.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static DAOraza getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOraza();
        }
        return instance;
    }

    /**
     * Método para recuperar un objeto de tipo raza de la base de datos en función de su atributo nombre (único).
     * @param nombre atributo que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo raza deseado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public Raza listarRaza(String nombre) throws SQLException {
        String query = "SELECT * FROM raza WHERE nombre=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Raza raza = new Raza(rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
        return raza;
    }
}
