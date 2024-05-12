package modelo;

public class Caracteristica {
    private String nombre;
    private int idCaract;
    private int puntuacion;
    private int modificador;

    public Caracteristica(String nombre, int idCaract, int puntuacion, int modificador) {
        this.nombre = nombre;
        this.idCaract = idCaract;
        this.puntuacion = puntuacion;
        this.modificador = modificador;
    }

    public Caracteristica(String nombre, int idCaract) {
        this.nombre = nombre;
        this.idCaract = idCaract;
    }

    public Caracteristica() {

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCaract() {
        return idCaract;
    }

    public void setIdCaract(int idCaract) {
        this.idCaract = idCaract;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getModificador() {
        return modificador;
    }

    public void setModificador(int modificador) {
        this.modificador = modificador;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "nombre='" + nombre + '\'' +
                ", idCaract=" + idCaract +
                ", puntuacion=" + puntuacion +
                ", modificador=" + modificador +
                '}';
    }
}

