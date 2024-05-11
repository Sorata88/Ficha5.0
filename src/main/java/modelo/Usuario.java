package modelo;

public class Usuario {
    private int idusuario;
    private String nickname;
    private String correo;
    private String permiso;

    public Usuario() {
    }

    public Usuario(int idusuario, String nickname, String correo, String permiso) {
        this.idusuario = idusuario;
        this.nickname = nickname;
        this.correo = correo;
        this.permiso = permiso;
    }

    public Usuario(String correo, String nickname, String permiso) {
        this.correo = correo;
        this.nickname = nickname;
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

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
