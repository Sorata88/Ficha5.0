package modelo;

import DAO.DAOclase;
import com.google.gson.Gson;

import java.sql.SQLException;

/**
 * Clase modelo de tipo clase. Crearemos objetos de esta clase para mostrarlas durante la creación y edición de la ficha.
 * Cada vez que invoquemos una entidad clase desde la base de datos, crearemos el objeto para mostrarlo en la "vista".
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class Clase {

    private int idclase;
    private String nombre;
    private String descripcion;
    private String dado_de_golpe;
    private String comp_armas_armadura;

    /**
     * Constructor vacío de la clase "clase".
     */
    public Clase() {
    }

    /**
     * Constructor completo de la clase "clase".
     * @param idclase identificador único del objeto de tipo "clase".
     * @param nombre nombre del objeto de tipo "clase".
     * @param descripcion descripción del objeto de tipo "clase".
     * @param dado_de_golpe atributo que almacena el "dado_de_golpe" del objeto de tipo "clase".
     * @param comp_armas_armadura atributo que almacena la "comp_armas_armadura" del objeto de tipo "clase".
     */
    public Clase(int idclase, String nombre, String descripcion, String dado_de_golpe, String comp_armas_armadura) {
        this.idclase = idclase;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dado_de_golpe = dado_de_golpe;
        this.comp_armas_armadura = comp_armas_armadura;
    }

    /**
     * Constructor de la clase "clase" sin el identificador. Lo usaremos cada vez que traigamos los datos de la base de datos
     * con la información pertinente a cada una de las "clases" disponibles.
     * @param nombre nombre del objeto de tipo "clase"
     * @param descripcion descripción del objeto de tipo "clase".
     * @param dado_de_golpe atributo que almacena el "dado_de_golpe" del objeto de tipo "clase".
     * @param comp_armas_armadura atributo que almacena la "comp_armas_armadura" del objeto de tipo "clase".
     */
    public Clase(String nombre, String descripcion, String dado_de_golpe, String comp_armas_armadura) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dado_de_golpe = dado_de_golpe;
        this.comp_armas_armadura = comp_armas_armadura;
    }

    /**
     * Método para recibir el valor actual del atributo "idclase" del objeto de tipo "clase".
     * @return devuelve el valor del atributo "idclase" del objeto de tipo "clase".
     */
    public int getIdclase() {
        return idclase;
    }

    /**
     * Método para modificar el valor del atributo "idraza" del objeto de tipo "clase".
     * @param idclase el nuevo valor que va a tener nuestro atributo "idclase" del objeto de tipo "clase".
     */
    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    /**
     * Método para recibir el valor actual del atributo "nombre" del objeto de tipo "clase"
     * @return devuelve el valor del atributo "nombre" del objeto de tipo "clase".
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el valor del atributo "nombre" del objeto de tipo "clase".
     * @param nombre el nuevo valor que va a tener nuestro atributo "nombre" del objeto de tipo "clase".
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para recibir el valor actual del atributo "descripcion" del objeto de tipo "clase".
     * @return devuelve el valor del atributo "descripcion" del objeto de tipo "clase".
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para modificar el valor del atributo "descripcion" del objeto de tipo "clase".
     * @param descripcion el nuevo valor que va a tener nuestro atributo "descripcion" del objeto de tipo "clase".
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para recibir el valor actual del atributo "dado_de_golpe" del objeto de tipo "clase".
     * @return devuelve el valor del atributo "dado_de_golpe" del objeto de tipo "clase".
     */
    public String getDado_de_golpe() {
        return dado_de_golpe;
    }

    /**
     * Método para modificar el valor del atributo "dado_de_golpe" del objeto de tipo "clase".
     * @param dado_de_golpe el nuevo valor que va a tener nuestro atributo "dado_de_golpe" del objeto de tipo "clase".
     */
    public void setDado_de_golpe(String dado_de_golpe) {
        this.dado_de_golpe = dado_de_golpe;
    }

    /**
     * Método para recibir el valor actual del atributo "comp_armas_armadura" del objeto de tipo "clase".
     * @return devuelve el valor del atributo "comp_armas_armadura" del objeto de tipo "clase".
     */
    public String getComp_armas_armadura() {
        return comp_armas_armadura;
    }

    /**
     * Método para modificar el valor del atributo "comp_armas_armadura" del objeto de tipo "clase".
     * @param comp_armas_armadura el nuevo valor que va a tener nuestro atributo "comp_armas_armadura" del objeto de tipo "clase".
     */
    public void setComp_armas_armadura(String comp_armas_armadura) {
        this.comp_armas_armadura = comp_armas_armadura;
    }

    /**
     * Método para listar todos los atributos del objeto de tipo "clase" de una manera clara y ordenada.
     * @return devuelve la lista de atributos del objeto de tipo "clase".
     */
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

    /**
     * Método para obtener los atributos de un objeto de tipo "clase" concreto en base a su atributo nombre (único).
     * @param nombre el atributo nombre del objeto de tipo "clase" que queremos recuperar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void listarClase(String nombre) throws SQLException {
        Clase prueba = DAOclase.getInstance().listarClase(nombre);
        this.setIdclase(prueba.getIdclase());
        this.setNombre(prueba.getNombre());
        this.setDescripcion(prueba.getDescripcion());
        this.setDado_de_golpe(prueba.getDado_de_golpe());
        this.setComp_armas_armadura(prueba.getComp_armas_armadura());
    }

    /**
     * Método para crear un objeto de tipo Gson de una librería externa. El objeto de tipo Gson almacenará los atributos
     * del objeto de tipo "clase" recogidos en el método anterior "listarClase" en un contenedor JSON.
     * @return devuelve el objeto de tipo String llamado json con los atributos del objeto de tipo "clase" almacenado.
     */
    public String claseJSON(){
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }
}
