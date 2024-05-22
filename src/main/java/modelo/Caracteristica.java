package modelo;

/**
 * Clase modelo de tipo caracteristica. Crearemos objetos de esta clase con cada creación de un objeto ficha.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class Caracteristica {
    private String nombre;
    private int idCaract;
    private int puntuacion;
    private int modificador;

    /**
     * Constructor completo de la clase caracteristica. Lo usaremos durante la creación de la ficha.
     * @param nombre atributo nombre del objeto de tipo caracteristica.
     * @param idCaract atributo idCaract del objeto de tipo caracteristica.
     * @param puntuacion atributo puntuacion del objeto de tipo caracteristica.
     * @param modificador atributo modificador del objeto de tipo caracteristica.
     */
    public Caracteristica(String nombre, int idCaract, int puntuacion, int modificador) {
        this.nombre = nombre;
        this.idCaract = idCaract;
        this.puntuacion = puntuacion;
        this.modificador = modificador;
    }

    /**
     * Constructor de la clase caracteristica con sólo dos atributos. Lo usaremos para listar desde la base de datos.
     * @param nombre atributo nombre del objeto de tipo caracteristica.
     * @param idCaract atributo idCaract del objeto de tipo caracteristica.
     */
    public Caracteristica(String nombre, int idCaract) {
        this.nombre = nombre;
        this.idCaract = idCaract;
    }

    /**
     * Constructor vacío de la clase caracteristica.
     */
    public Caracteristica() {

    }

    /**
     * Método para recibir el valor actual del atributo "nombre" del objeto de tipo caracteristica.
     * @return devuelve el valor del atributo "nombre" del objeto de tipo caracteristica.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el valor del atributo "nombre" del objeto de tipo caracteristica.
     * @param nombre el nuevo valor que va a tener nuestro atributo "nombre" del objeto de tipo caracteristica.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para recibir el valor actual del atributo "idCaract" del objeto de tipo caracteristica.
     * @return devuelve el valor del atributo "idCaract" del objeto de tipo caracteristica.
     */
    public int getIdCaract() {
        return idCaract;
    }

    /**
     * Método para modificar el valor del atributo "idCaract" del objeto de tipo caracteristica.
     * @param idCaract el nuevo valor que va a tener nuestro atributo "idCaract" del objeto de tipo caracteristica.
     */
    public void setIdCaract(int idCaract) {
        this.idCaract = idCaract;
    }

    /**
     * Método para recibir el valor actual del atributo "puntuacion" del objeto de tipo caracteristica.
     * @return devuelve el valor del atributo "puntuacion" del objeto de tipo caracteristica.
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Método para modificar el valor del atributo "puntuacion" del objeto de tipo caracteristica.
     * @param puntuacion el nuevo valor que va a tener nuestro atributo "puntuacion" del objeto de tipo caracteristica.
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Método para recibir el valor actual del atributo "modificador" del objeto de tipo caracteristica.
     * @return devuelve el valor del atributo "modificador" del objeto de tipo caracteristica.
     */
    public int getModificador() {
        return modificador;
    }

    /**
     * Método para modificar el valor del atributo "modificador" del objeto de tipo caracteristica.
     * @param modificador el nuevo valor que va a tener nuestro atributo "modificador" del objeto de tipo caracteristica.
     */
    public void setModificador(int modificador) {
        this.modificador = modificador;
    }

    /**
     * Método para listar todos los atributos del objeto de tipo caracteristica de una manera clara y ordenada.
     * @return devuelve la lista de atributos del objeto de tipo caracteristica.
     */
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

