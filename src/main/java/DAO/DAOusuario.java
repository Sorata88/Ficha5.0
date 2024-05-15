package DAO;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void crear_usuario(Usuario u) throws SQLException{

        String query = "INSERT INTO usuario (idusuario, nickname, correo, nivel_permiso) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, u.getIdusuario());
            ps.setString(2, u.getNickname());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getPermiso());
            ps.executeUpdate();
            ps.close();

            ps.close();
    }
}
