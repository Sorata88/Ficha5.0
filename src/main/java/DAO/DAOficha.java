package DAO;

import modelo.Ficha;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void insertarCaract( int idFicha, int idCaract, int punt, int mod){
        String query2 = "INSERT INTO caracteristica_ficha (idficha, idcaract, puntuacion, modificador) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query2)) {
            ps.setInt(1, idFicha);
            ps.setInt(2, idCaract);
            ps.setInt(3, punt);
            ps.setInt(4, mod);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crear_ficha(Ficha n) throws SQLException{

        String query = "INSERT INTO ficha (idficha, nombre, nombrepj, idraza, idclase, nivel, trasfondo, alineamiento, px) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

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
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            n.setIdficha(rs.getInt(1));

            ps.close();
        }

        insertarCaract(n.getIdficha(), n.getFUE().getIdCaract(), n.getFUE().getPuntuacion(), n.getFUE().getModificador());

        insertarCaract(n.getIdficha(), n.getDES().getIdCaract(), n.getDES().getPuntuacion(), n.getDES().getModificador());

        insertarCaract(n.getIdficha(), n.getCON().getIdCaract(), n.getCON().getPuntuacion(), n.getCON().getModificador());

        insertarCaract(n.getIdficha(), n.getINT().getIdCaract(), n.getINT().getPuntuacion(), n.getINT().getModificador());

        insertarCaract(n.getIdficha(), n.getSAB().getIdCaract(), n.getSAB().getPuntuacion(), n.getSAB().getModificador());

        insertarCaract(n.getIdficha(), n.getCAR().getIdCaract(), n.getCAR().getPuntuacion(), n.getCAR().getModificador());


        /*String query2 = "INSERT INTO caracteristica_ficha (idficha, idcaract, puntuacion, modificador) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query2)) {

            ps.setInt(1, n.getIdficha());
            ps.setInt(2, n.getFUE().getIdCaract());
            ps.setInt(3, n.getFUE().getPuntuacion());
            ps.setInt(4, n.getFUE().getModificador());
            ps.setInt(1, 10);
            ps.setInt(2, n.getDES().getIdCaract());
            ps.setInt(3, n.getDES().getPuntuacion());
            ps.setInt(4, n.getDES().getModificador());
            ps.setInt(1, 10);
            ps.setInt(2, n.getCON().getIdCaract());
            ps.setInt(3, n.getCON().getPuntuacion());
            ps.setInt(4, n.getCON().getModificador());
            ps.setInt(1, 10);
            ps.setInt(2, n.getINT().getIdCaract());
            ps.setInt(3, n.getINT().getPuntuacion());
            ps.setInt(4, n.getINT().getModificador());
            ps.setInt(1, 10);
            ps.setInt(2, n.getSAB().getIdCaract());
            ps.setInt(3, n.getSAB().getPuntuacion());
            ps.setInt(4, n.getSAB().getModificador());
            ps.setInt(1, 10);
            ps.setInt(2, n.getCAR().getIdCaract());
            ps.setInt(3, n.getCAR().getPuntuacion());
            ps.setInt(4, n.getCAR().getModificador());

            ps.executeUpdate();

            ps.close();


        }*/

    }


}
