package modelo;

import DAO.DAOraza;
import com.google.gson.Gson;

import java.sql.SQLException;

/**
 * Clase modelo de tipo raza. Crearemos objetos de esta clase para mostrarlas durante la creación y edición de la ficha.
 * Cada vez que invoquemos una entidad raza desde la base de datos, crearemos el objeto para mostrarlo en la "vista".
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class Raza {

    private int idraza;
    private String nombre;
    private String mejora_leve;
    private String mejora_moderada;
    private String size;
    private String velocidad;
    private String idiomas;
    private String atributo_racial;

    /**
     * Constructor vacío de la clase raza.
     */
    public Raza() {
    }

    /**
     * Constructor completo de la clase raza.
     * @param idraza identificador único del objeto de tipo raza.
     * @param nombre nombre del objeto de tipo raza.
     * @param mejora_leve una de las dos mejoras asociadas a la clase raza.
     * @param mejora_moderada una de las dos mejoras asociadas a la clase raza.
     * @param size tamaño de la raza en el ámbito del juego.
     * @param velocidad velocidad en pies de la raza en el ámbito del juego.
     * @param idiomas idiomas que domina la raza en el ámbito del juego.
     * @param atributo_racial otros atributos asociados a la clase raza.
     */
    public Raza(int idraza, String nombre, String mejora_leve, String mejora_moderada, String size, String velocidad, String idiomas, String atributo_racial) {
        this.idraza = idraza;
        this.nombre = nombre;
        this.mejora_leve = mejora_leve;
        this.mejora_moderada = mejora_moderada;
        this.size = size;
        this.velocidad = velocidad;
        this.idiomas = idiomas;
        this.atributo_racial = atributo_racial;
    }
    /**
     * Constructor de la clase raza sin el identificador. Lo usaremos cada vez que traigamos los datos de la base de datos
     * con la información pertinente a cada una de las razas disponibles.
     * @param nombre nombre del objeto de tipo raza.
     * @param mejora_leve una de las dos mejoras asociadas a la raza.
     * @param mejora_moderada una de las dos mejoras asociadas a la raza.
     * @param size tamaño de la raza en el ámbito del juego.
     * @param velocidad velocidad en pies de la raza en el ámbito del juego.
     * @param idiomas idiomas que domina la raza en el ámbito del juego.
     * @param atributo_racial otros atributos asociados a la raza.
     */
    public Raza(String nombre, String mejora_leve, String mejora_moderada, String size, String velocidad, String idiomas, String atributo_racial) {
        this.nombre = nombre;
        this.mejora_leve = mejora_leve;
        this.mejora_moderada = mejora_moderada;
        this.size = size;
        this.velocidad = velocidad;
        this.idiomas = idiomas;
        this.atributo_racial = atributo_racial;
    }

    /**
     * Método para obtener los atributos de un objeto de tipo raza concreto en base a su atributo nombre (único).
     * @param nombre el atributo nombre del objeto de tipo raza que queremos recuperar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void listarRaza(String nombre) throws SQLException {
        Raza prueba = DAOraza.getInstance().listarRaza(nombre);
        this.setNombre(prueba.getNombre());
        this.setMejora_leve(prueba.getMejora_leve());
        this.setMejora_moderada(prueba.getMejora_moderada());
        this.setSize(prueba.getSize());
        this.setVelocidad(prueba.getVelocidad());
        this.setIdiomas(prueba.getIdiomas());
        this.setAtributo_racial(prueba.getAtributo_racial());

    }

    /**
     * Método para crear un objeto de tipo Gson de una librería externa. El objeto de tipo Gson almacenará los atributos
     * del objeto de tipo raza recogidos en el método anterior "listarRaza" en un contenedor JSON.
     * @return devuelve el objeto de tipo String llamado json con los atributos del objeto de tipo raza almacenado.
     */
    public String razaJSON(){
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

    /**
     * Método para recibir el valor actual del atributo "idraza" del objeto de tipo raza.
     * @return devuelve el valor del atributo "idraza" del objeto de tipo raza.
     */
    public int getIdraza() {
        return idraza;
    }

    /**
     * Método para modificar el valor del atributo "idraza" del objeto de tipo raza.
     * @param idraza el nuevo valor que va a tener nuestro atributo "idraza" del objeto de tipo raza.
     */
    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    /**
     * Método para recibir el valor actual del atributo "nombre" del objeto de tipo raza.
     * @return devuelve el valor del atributo "nombre" del objeto de tipo raza.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el valor del atributo "nombre" del objeto de tipo raza.
     * @param nombre el nuevo valor que va a tener nuestro atributo "nombre" del objeto de tipo raza.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para recibir el valor actual del atributo "mejora_leve" del objeto de tipo raza.
     * @return devuelve el valor del atributo "mejora_leve" del objeto de tipo raza.
     */
    public String getMejora_leve() {
        return mejora_leve;
    }

    /**
     * Método para modificar el valor del atributo "mejora_leve" del objeto de tipo raza.
     * @param mejora_leve el nuevo valor que va a tener nuestro atributo "mejora_leve" del objeto de tipo raza.
     */
    public void setMejora_leve(String mejora_leve) {
        this.mejora_leve = mejora_leve;
    }

    /**
     * Método para recibir el valor actual del atributo "mejora_moderada" del objeto de tipo raza.
     * @return devuelve el valor del atributo "mejora_moderada" del objeto de tipo raza.
     */
    public String getMejora_moderada() {
        return mejora_moderada;
    }

    /**
     * Método para modificar el valor del atributo "mejora_moderada" del objeto de tipo raza.
     * @param mejora_moderada el nuevo valor que va a tener nuestro atributo "mejora_moderada" del objeto de tipo raza.
     */
    public void setMejora_moderada(String mejora_moderada) {
        this.mejora_moderada = mejora_moderada;
    }

    /**
     * Método para recibir el valor actual del atributo "size" del objeto de tipo raza.
     * @return devuelve el valor del atributo "size" del objeto de tipo raza.
     */
    public String getSize() {
        return size;
    }

    /**
     * Método para modificar el valor del atributo "size" del objeto de tipo raza.
     * @param size el nuevo valor que va a tener nuestro atributo "size" del objeto de tipo raza.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Método para recibir el valor actual del atributo "velocidad" del objeto de tipo raza.
     * @return devuelve el valor del atributo "velocidad" del objeto de tipo raza.
     */
    public String getVelocidad() {
        return velocidad;
    }

    /**
     * Método para modificar el valor del atributo "velocidad" del objeto de tipo raza.
     * @param velocidad el nuevo valor que va a tener nuestro atributo "velocidad" del objeto de tipo raza.
     */
    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Método para recibir el valor actual del atributo "velocidad" del objeto de tipo raza.
     * @return devuelve el valor del atributo "velocidad" del objeto de tipo raza.
     */
    public String getIdiomas() {
        return idiomas;
    }

    /**
     * Método para modificar el valor del atributo "idiomas" del objeto de tipo raza.
     * @param idiomas el nuevo valor que va a tener nuestro atributo "idiomas" del objeto de tipo raza.
     */
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    /**
     * Método para recibir el valor actual del atributo "atributo_racial" del objeto de tipo raza.
     * @return devuelve el valor del atributo "atributo_racial" del objeto de tipo raza.
     */
    public String getAtributo_racial() {
        return atributo_racial;
    }

    /**
     * Método para modificar el valor del atributo "atributo_racial" del objeto de tipo raza.
     * @param atributo_racial el nuevo valor que va a tener nuestro atributo "atributo_racial" del objeto de tipo raza.
     */
    public void setAtributo_racial(String atributo_racial) {
        this.atributo_racial = atributo_racial;
    }

    /**
     * Método para listar todos los atributos del objeto de tipo raza de una manera clara y ordenada.
     * @return devuelve la lista de atributos del objeto de tipo raza.
     */
    @Override
    public String toString() {
        return "Raza{" +
                "idraza=" + idraza +
                ", nombre='" + nombre + '\'' +
                ", mejora_leve='" + mejora_leve + '\'' +
                ", mejora_moderada='" + mejora_moderada + '\'' +
                ", size='" + size + '\'' +
                ", velocidad='" + velocidad + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", atributo_racial='" + atributo_racial + '\'' +
                '}';
    }
}
