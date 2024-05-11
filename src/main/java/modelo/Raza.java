package modelo;

public class Raza {

    private int idraza;
    private String nombre;
    private String mejora_leve;
    private String mejora_moderada;
    private String size;
    private int velocidad;
    private String idiomas;

    public Raza() {
    }

    public Raza(int idraza, String nombre, String mejora_leve, String mejora_moderada, String size, int velocidad, String idiomas) {
        this.idraza = idraza;
        this.nombre = nombre;
        this.mejora_leve = mejora_leve;
        this.mejora_moderada = mejora_moderada;
        this.size = size;
        this.velocidad = velocidad;
        this.idiomas = idiomas;
    }

    public Raza(String nombre, String mejora_leve, String mejora_moderada, String size, int velocidad, String idiomas) {
        this.nombre = nombre;
        this.mejora_leve = mejora_leve;
        this.mejora_moderada = mejora_moderada;
        this.size = size;
        this.velocidad = velocidad;
        this.idiomas = idiomas;
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMejora_leve() {
        return mejora_leve;
    }

    public void setMejora_leve(String mejora_leve) {
        this.mejora_leve = mejora_leve;
    }

    public String getMejora_moderada() {
        return mejora_moderada;
    }

    public void setMejora_moderada(String mejora_moderada) {
        this.mejora_moderada = mejora_moderada;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "idraza=" + idraza +
                ", nombre='" + nombre + '\'' +
                ", mejora_leve='" + mejora_leve + '\'' +
                ", mejora_moderada='" + mejora_moderada + '\'' +
                ", size='" + size + '\'' +
                ", velocidad=" + velocidad +
                ", idiomas='" + idiomas + '\'' +
                '}';
    }
}
