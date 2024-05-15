package DAO;

import modelo.Clase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOclase {

    private Connection conn = null;
    private static DAOclase instance = null;


    public DAOclase() throws SQLException {
        conn = DBconnection.getConnection();
    }

    public static DAOclase getInstance() throws SQLException {
        if (instance == null) {
            instance = new DAOclase();
        }
        return instance;
    }

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
