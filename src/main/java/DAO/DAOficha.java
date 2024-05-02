package DAO;

import modelo.Ficha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOficha {

    private Connection conn = null;
    private static DAOficha instance = null;

    public DAOficha() throws SQLException {
        conn = DBconnection.getConnection();
    }

    public static DAOficha getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOficha();
        }
        return instance;
    }

    public void crear_ficha(Ficha n) throws SQLException{

        String query = "INSERT INTO ficha (idficha, nombre, nombrepj, idraza, idclase, nivel, trasfondo, alineamiento, px) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, n.getIdficha());
            ps.setString(2, n.getNombre());
            ps.setString(3, n.getNombrepj());
            ps.setInt(4, n.getIdraza());
            ps.setInt(5, n.getIdclase());
            ps.setInt(6, n.getNivel());
            ps.setString(7, n.getTrasfondo());
            ps.setString(8, n.getAlineamiento());
            ps.setInt(9, n.getPx());

            ps.executeUpdate();

            ps.close();
        }

    }


}
