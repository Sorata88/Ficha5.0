package modelo;

public class Clase {

    private int idclase;
    private String nombre;
    private String descripcion;
    private String dado_de_golpe;
    private String comp_armas_armadura;

    public Clase() {
    }

    public Clase(int idclase, String nombre, String descripcion, String dado_de_golpe, String comp_armas_armadura) {
        this.idclase = idclase;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dado_de_golpe = dado_de_golpe;
        this.comp_armas_armadura = comp_armas_armadura;
    }

    public Clase(String nombre, String descripcion, String dado_de_golpe, String comp_armas_armadura) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dado_de_golpe = dado_de_golpe;
        this.comp_armas_armadura = comp_armas_armadura;
    }

    public int getIdclase() {
        return idclase;
    }

    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDado_de_golpe() {
        return dado_de_golpe;
    }

    public void setDado_de_golpe(String dado_de_golpe) {
        this.dado_de_golpe = dado_de_golpe;
    }

    public String getComp_armas_armadura() {
        return comp_armas_armadura;
    }

    public void setComp_armas_armadura(String comp_armas_armadura) {
        this.comp_armas_armadura = comp_armas_armadura;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "idclase=" + idclase +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dado_de_golpe='" + dado_de_golpe + '\'' +
                ", comp_armas_armadura='" + comp_armas_armadura + '\'' +
                '}';
    }
}
