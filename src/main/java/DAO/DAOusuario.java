package DAO;

import com.google.gson.Gson;
import modelo.Ficha;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        String query = "INSERT INTO usuario (idusuario, nickname, correo, password, nivel_permiso) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, u.getIdusuario());
            ps.setString(2, u.getNickname());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getPermiso());
            ps.executeUpdate();
            ps.close();
    }

    public Usuario login(Usuario u) throws SQLException{
        String query = "SELECT * FROM usuario WHERE nickname = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, u.getNickname());
        ps.setString(2, u.getPassword());
        ResultSet rs = ps.executeQuery();
        Usuario user = null;
        if(rs.next()){
            user = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                               rs.getString(4), rs.getInt(5));
        }
        return user;
    }

    public ArrayList<Usuario> listar_usuario() throws SQLException{

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuario");
        ResultSet rs = ps.executeQuery();

        ArrayList<Usuario> lista_usuario = null;
        while(rs.next()) {
            if(lista_usuario == null) {
                lista_usuario = new ArrayList<>();
            }
            lista_usuario.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                                          rs.getString(4), rs.getInt(5)));
        }
        return lista_usuario;
    }

    public String listarJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar_usuario());
        return json;
    }

    public Usuario obtenerID(int id) throws SQLException{
        String query = "SELECT * FROM usuario WHERE idusuario = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getInt(5));
        return u;
    }

    public void actualizarUsuario(Usuario u) throws SQLException{

        String query = "UPDATE usuario SET nickname=?, correo=?, password=?, nivel_permiso=? WHERE idusuario=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, u.getNickname());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getPermiso());
            ps.setInt(5, u.getIdusuario());
            ps.executeUpdate();
            ps.close();
        }
    }

    public void borrarUsuario(int idusuario) throws SQLException {
        String query = "DELETE FROM usuario WHERE idusuario=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idusuario);
        ps.executeUpdate();
        ps.close();
    }
}
