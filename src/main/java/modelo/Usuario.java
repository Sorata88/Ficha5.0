package modelo;

import DAO.DAOficha;
import DAO.DAOusuario;
import com.google.gson.Gson;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Usuario {
    private int idusuario;
    private String nickname;
    private String correo;
    private String password;
    private int permiso;

    public Usuario() {

    }

    public Usuario(int idusuario, String nickname, String correo, String password, int permiso) {
        this.idusuario = idusuario;
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.permiso = permiso;
    }

    public Usuario(String nickname, String correo, String password, int permiso) {
        this.nickname = nickname;
        this.correo = correo;
        this.password = password;
        this.permiso = permiso;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

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

    public void crear_usuario() throws SQLException {
        DAOusuario.getInstance().crear_usuario(this);
    }

    public void actualizarUsuario() throws SQLException {
        DAOusuario.getInstance().actualizarUsuario(this);
    }

    public void borrarUsuario(int id) throws SQLException {
        DAOusuario.getInstance().borrarUsuario(id);
    }

    public void obtenerID(int id) throws SQLException {
        Usuario aux = DAOusuario.getInstance().obtenerID(id);

        this.setIdusuario(aux.getIdusuario());
        this.setNickname(aux.getNickname());
        this.setCorreo(aux.getCorreo());
        this.setPassword(aux.getPassword());
        this.setPermiso(aux.getPermiso());
    }

    public String dameJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

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
