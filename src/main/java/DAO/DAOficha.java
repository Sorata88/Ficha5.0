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

        String query = "INSERT INTO ficha (idficha, idjugador, nombre, nombrepj, idraza, idclase, nivel, trasfondo, alineamiento, xp, bono_competencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, n.getIdficha());
        ps.setInt(2, n.getIdjugador());
        ps.setString(3, n.getNombre());
        ps.setString(4, n.getNombrepj());
        ps.setInt(5, n.getIdraza());
        ps.setInt(6, n.getIdclase());
        ps.setInt(7, n.getNivel());
        ps.setString(8, n.getTrasfondo());
        ps.setInt(9, n.getAlineamiento());
        //noinspection JpaQueryApiInspection
        ps.setInt(10, n.getXp());
        //noinspection JpaQueryApiInspection
        ps.setInt(11, n.getBono_competencia());
        ps.executeUpdate();

        ps.close();

    }


}
