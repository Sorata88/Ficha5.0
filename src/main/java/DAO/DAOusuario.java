package DAO;

import com.google.gson.Gson;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase DAO (Data Access Objet) de la clase usuario. Permite encapsular toda la lógica de acceso a datos del resto de
 * la aplicación.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class DAOusuario {

    private Connection conn = null;
    private static DAOusuario instance = null;

    /**
     * Método que nos permite conectarnos a la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public DAOusuario() throws SQLException {
        conn = DBconnection.getConnection();
    }

    /**
     * Método que implementa el patrón de diseño "Singleton" para la clase usuario. Sólo permite una instancia de la
     * clase para toda la aplicación. Si no existe, creará el objeto, en caso contrario, lo invocará desde la memoria.
     * @return devuelve el objeto DAO de la clase usuario.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static DAOusuario getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOusuario();
        }
        return instance;
    }

    /**
     * Método para insertar un nuevo objeto de tipo usuario en la base de datos.
     * @param u objeto de tipo usuario que le pasamos al método como parámetro.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
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

    /**
     * Método para iniciar sesión mediante una comprobación de existencia con la base de datos. Si existe, devuelve
     * los atributos del usuario buscado.
     * @param u objeto de tipo usuario que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo usuario buscado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
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

    /**
     * Método para recoger todos los objetos de tipo usuario de la base de datos y almacenarlos en un "array" de usuarios.
     * @return devuelve el "array" de objetos de tipo usuario.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
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

    /**
     * Método para convertir el "array" de objetos de tipo usuario recuperado en el método "listar_usuario" anterior.
     * @return devuelve el objeto de tipo String con todos los datos del array en formato JSON.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String listarJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar_usuario());
        return json;
    }

    /**
     * Método para recuperar un objeto concreto de tipo usuario de la base de datos usando su identificador único.
     * @param id atributo del objeto de tipo usuario que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo usuario deseado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
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

    /**
     * Método para actualizar los datos (atributos) de un objeto de tipo usuario ya existente en la base de datos.
     * @param u objeto de tipo usuario que le pasamos al método como parámentro.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
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

    /**
     * Método para eliminar un objeto de tipo usuario de la base de datos.
     * @param idusuario el atributo identificativo del usuario que queremos borrar.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void borrarUsuario(int idusuario) throws SQLException {
        String query = "DELETE FROM usuario WHERE idusuario=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idusuario);
        ps.executeUpdate();
        ps.close();
    }
}
