package DAO;

import modelo.Raza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOraza {

    private Connection conn = null;
    private static DAOraza instance = null;


    public DAOraza() throws SQLException {
        conn = DBconnection.getConnection();
    }

    public static DAOraza getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOraza();
        }
        return instance;
    }

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
