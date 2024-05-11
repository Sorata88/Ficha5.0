package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOusuario {

    private Connection conn = null;
    private static DAOusuario instance = null;


    public DAOusuario() throws SQLException {
        conn = DBconnection.getConnection();
    }

    public static DAOusuario getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOusuario();
        }
        return instance;
    }
}
