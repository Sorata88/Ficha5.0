package modelo;

import DAO.DAOusuario;
import com.google.gson.Gson;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Clase modelo de tipo usuario. Crearemos objetos de esta clase por cada usuario que se registre en nuestra app web.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class Usuario {
    private int idusuario;
    private String nickname;
    private String correo;
    private String password;
    private int permiso;

    /**
     * Constructor vacío de la clase usuario. Lo utilizaremos varias veces en nuestro CRUD de usuarios.
     */
    public Usuario() {

    }

    /**
     * Constructor completo de la clase usuario. Lo usaremos a la hora de listar usuarios desde la DDBB.
     * @param idusuario identificador único de la clase usuario.
     * @param nickname nombre del objeto usuario.
     * @param correo correo electrónico del objeto usuario.
     * @param password contraseña ya encriptada del objeto usuario.
     * @param permiso el nivel de permiso de la clase usuario.
     */
    public Usuario(int idusuario, String nickname, String correo, String password, int permiso) {
        this.idusuario = idusuario;
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.permiso = permiso;
    }

    /**
     * Constructor de la clase usuario sin el identificador. Lo usaremos a la hora de crear nuevos usuarios.
     * @param nickname nombre del objeto usuario.
     * @param correo correo electrónico del objeto usuario.
     * @param password contraseña ya encriptada del objeto usuario.
     * @param permiso el nivel de permiso de la clase usuario.
     */
    public Usuario(String nickname, String correo, String password, int permiso) {
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.permiso = permiso;
    }

    /**
     * Método para recibir el valor actual del atributo "idusuario" del objeto usuario.
     * @return devuelve el valor del atributo "idusuario" del objeto usuario.
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * Método para modificar el valor del atributo "idusuario" del objeto usuario.
     * @param idusuario el nuevo valor que va a tener nuestro atributo "idusuario" del objeto usuario.
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * Método para recibir el valor actual del atributo "nickname" del objeto usuario.
     * @return devuelve el valor del atributo "nickname" del objeto usuario.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Método para modificar el valor del atributo "nickname" del objeto usuario.
     * @param nickname el nuevo valor que va a tener nuestro atributo "nickname" del objeto usuario.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Método para recibir el valor actual del atributo "correo" del objeto usuario.
     * @return devuelve el valor del atributo "correo" del objeto usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método para modificar el valor del atributo "correo" del objeto usuario.
     * @param correo el nuevo valor que va a tener nuestro atributo "correo" del objeto usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método para recibir el valor actual del atributo "password" del objeto usuario.
     * @return devuelve el valor del atributo "password" del objeto usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método para modificar el valor del atributo "password" del objeto usuario.
     * @param password el nuevo valor que va a tener nuestro atributo "password" del objeto usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para recibir el valor actual del atributo "permiso" del objeto usuario.
     * @return devuelve el valor del atributo "permiso" del objeto usuario.
     */
    public int getPermiso() {
        return permiso;
    }

    /**
     * Método para modificar el valor del atributo "permiso" del objeto usuario.
     * @param permiso el nuevo valor que va a tener nuestro atributo "permiso" del objeto usuario.
     */
    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    /**
     * Método para listar todos los atributos del objeto usuario de una manera clara y ordenada.
     * @return devuelve la lista de atributos del objeto usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", permiso='" + permiso + '\'' +
                '}';
    }

    /**
     * Método para crear un nuevo objeto de tipo usuario. Llamaremos al método crear usuario de la capa DAO.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void crear_usuario() throws SQLException {
        DAOusuario.getInstance().crear_usuario(this);
    }

    /**
     * Método para actualizar los atributos de un objeto de tipo usuario ya existente. Llamaremos al método actualizar usuario de la capa DAO.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void actualizarUsuario() throws SQLException {
        DAOusuario.getInstance().actualizarUsuario(this);
    }

    /**
     * Método para borrar un objeto de tipo usuario de la base de datos. Necesitaremos el identificador de ese objeto
     * para poder eliminarlo de la base de datos. Llamaremos el método eliminar usuario de la capa DAO.
     * @param id el atributo id del objeto de tipo usuario que deseamos borrar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void borrarUsuario(int id) throws SQLException {
        DAOusuario.getInstance().borrarUsuario(id);
    }

    /**
     * Método para obtener los atributos de un objeto de tipo usuario concreto en base a su atributo id (único).
     * @param id el atributo id del objeto de tipo usuario que queremos recuperar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void obtenerID(int id) throws SQLException {
        Usuario aux = DAOusuario.getInstance().obtenerID(id);

        this.setIdusuario(aux.getIdusuario());
        this.setNickname(aux.getNickname());
        this.setCorreo(aux.getCorreo());
        this.setPassword(aux.getPassword());
        this.setPermiso(aux.getPermiso());
    }

    /**
     * Método para crear un objeto de tipo Gson de una librería externa. El objeto de tipo Gson almacenará los atributos
     * del objeto de tipo usuario recogidos en el método anterior "ObtenerID" en un contenedor JSON.
     * @return devuelve el objeto de tipo String llamado json con los atributos del objeto de tipo usuario almacenado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String dameJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

    /**
     * Método de tipo booleano que verifica si los datos introducidos por el usuario en el formulario de inicio de sesión
     * existen en la base de datos. De ser así, devuelve un "true" y el usuario puede iniciar sesión en la app web.
     * @return devuelve el valor del objeto de tipo booleano.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public boolean log_in() throws SQLException {
        boolean ok = false;
        Usuario user = DAOusuario.getInstance().login(this);
        if (user != null) {
            this.setIdusuario(user.getIdusuario());
            this.setNickname(user.getNickname());
            this.setCorreo(user.getCorreo());
            this.setPassword(user.getPassword());
            this.setPermiso(user.getPermiso());
            ok = true;
        }
        return ok;
    }

    /**
     * Método para encriptar la contraseña del objeto de tipo usuario. Es un proceso requerido debido a la actual
     * Ley Orgánica 3/2018, de 5 de diciembre, de Protección de Datos Personales y garantía de los derechos digitales.
     * @see "https://www.boe.es/buscar/pdf/2018/BOE-A-2018-16673-consolidado.pdf"
     * @param input
     * @return
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
