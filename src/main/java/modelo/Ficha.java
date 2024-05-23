package modelo;

import DAO.DAOficha;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase modelo de tipo "ficha". Crearemos objetos de esta clase por cada ficha de jugador de la app web.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class Ficha {

    private int idficha;
    private String nombre;
    private String nombrepj;
    private String raza;
    private String clase;
    private int nivel;
    private String trasfondo;
    private String alineamiento;
    private int px;
    private int bono_competencia;
    private Caracteristica Caract[] = new Caracteristica[6];

    /**
     * Constructor vacío de la clase "ficha".
     */
    public Ficha() {
    }

    /**
     * Constructor completo de la clase "ficha". Lo usaremos a la hora de traer objetos "ficha" desde la base de datos.
     * @param idficha identificador único de la clase "ficha".
     * @param nombre nombre del jugador al que pertenece el objeto "ficha". Se relaciona con la clase "usuario".
     * @param nombrepj nombre ficticio del jugador al que pertenece el objeto "ficha".
     * @param raza atributo "raza" del objeto de tipo "ficha".
     * @param clase atributo "clase" del objeto de tipo "ficha".
     * @param nivel atributo "nivel" del objeto de tipo "ficha".
     * @param trasfondo atributo "trasfondo" del objeto de tipo "ficha".
     * @param alineamiento atributo "alineamiento" del objeto de tipo "ficha".
     * @param px atributo "px" del objeto de tipo "ficha".
     * @param bono_competencia atributo "bono_competencia" del objeto de tipo "ficha".
     */
    public Ficha(int idficha, String nombre, String nombrepj, String raza, String clase, int nivel, String trasfondo, String alineamiento, int px, int bono_competencia) {
        this.idficha = idficha;
        this.nombre = nombre;
        this.nombrepj = nombrepj;
        this.raza = raza;
        this.clase = clase;
        this.nivel = nivel;
        this.trasfondo = trasfondo;
        this.alineamiento = alineamiento;
        this.px = px;
        this.bono_competencia = bono_competencia;
        inicializar();
    }

    /**
     * Constructor de la clase "ficha" sin el identificador. Lo usaremos a la hora de crear nuevas fichas.
     * @param nombre nombre del jugador al que pertenece el objeto "ficha". Se relaciona con la clase "usuario".
     * @param nombrepj nombre ficticio del jugador al que pertenece el objeto "ficha".
     * @param raza atributo "raza" del objeto de tipo "ficha".
     * @param clase atributo "clase" del objeto de tipo "ficha".
     * @param nivel atributo "nivel" del objeto de tipo "ficha".
     * @param trasfondo atributo "trasfondo" del objeto de tipo "ficha".
     * @param alineamiento atributo "alineamiento" del objeto de tipo "ficha".
     * @param px atributo "px" del objeto de tipo "ficha".
     * @param bono_competencia atributo "bono_competencia" del objeto de tipo "ficha".
     */
    public Ficha(String nombre, String nombrepj, String raza, String clase, int nivel, String trasfondo, String alineamiento, int px, int bono_competencia) {
        this.nombre = nombre;
        this.nombrepj = nombrepj;
        this.raza = raza;
        this.clase = clase;
        this.nivel = nivel;
        this.trasfondo = trasfondo;
        this.alineamiento = alineamiento;
        this.px = px;
        this.bono_competencia = bono_competencia;
        inicializar();

    }

    /**
     * Método para inicializar el array de tipo "caracteristica" que está vinculado a cada objeto de tipo "ficha".
     */
    private void inicializar(){
        Caract[0] = new Caracteristica("Fuerza",1);
        Caract[1] = new Caracteristica("Destreza",2);
        Caract[2] = new Caracteristica("Constitución",3);
        Caract[3] = new Caracteristica("Inteligencia",4);
        Caract[4] = new Caracteristica("Sabiduría",5);
        Caract[5] = new Caracteristica("Carisma",6);
    }

    /**
     * Método para rellenar los atributos del objeto Caract de tipo "caracteristica".
     * @param id atributo "id" que le pasamos al método.
     * @param punt atributo "punt" que le pasamos al método.
     * @param mod atributo "mod" que le pasamos al método.
     */
    public void setCaract(int id, int punt, int mod){

        int i = 0;
        do {
            if (Caract[i].getIdCaract() == id) {
                    Caract[i].setPuntuacion(punt);
                    Caract[i].setModificador(mod);
            }
            i++;
        } while (Caract[i-1].getIdCaract() != id);

         /*for (int i=0;i<Caract.length;i++) {
            if (Caract[i].getIdCaract() == id) {
                Caract[i].setPuntuacion(punt);
                Caract[i].setModificador(mod);
            }
        }*/

    }

    /**
     * Método para crear un nuevo objeto de tipo ficha. Llamaremos al método crear ficha de la capa DAO.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void crear_ficha() throws SQLException {
        DAOficha.getInstance().crear_ficha(this);
    }

    /**
     * Método para listar un sólo objeto de tipo ficha asociado a un atributo nombre de un objeto de tipo usuario usuario (único).
     * @param nombre atributo que le vamos a pasar al método para obtener el objeto ficha que deseamos.
     * @return devuelve el objeto de tipo String llamado json con los atributos del objeto de tipo ficha almacenado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String listar_ficha_usuario(String nombre) throws SQLException {
       ArrayList<Ficha> aux = DAOficha.getInstance().listar_ficha_usuario(nombre);

        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(aux);
        return json;
    }

    /**
     * Método para actualizar los atributos de un objeto de tipo ficha ya existente. Llamaremos al método actualizar ficha de la capa DAO.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void actualizarFicha() throws SQLException {
        DAOficha.getInstance().actualizarFicha(this);
    }

    /**
     * Método para borrar un objeto de tipo ficha de la base de datos. Necesitaremos el identificador de ese objeto
     * para poder eliminarlo de la base de datos. Llamaremos al método eliminar ficha de la capa DAO.
     * @param id el atributo id del objeto de tipo ficha que deseamos borrar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void borrarFicha(int id) throws SQLException {
        DAOficha.getInstance().borrarFicha(id);
    }

    /**
     * Método para obtener los atributos de un objeto de tipo ficha concreto en base a su atributo id (único).
     * @param id el atributo id del objeto de tipo ficha que queremos recuperar de la base de datos.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void obtenerID(int id) throws SQLException {
        Ficha aux = DAOficha.getInstance().obtenerID(id);

        this.setIdficha(aux.getIdficha());
        this.setNombre(aux.getNombre());
        this.setNombrepj(aux.getNombrepj());
        this.setRaza(aux.getRaza());
        this.setClase(aux.getClase());
        this.setNivel(aux.getNivel());
        this.setTrasfondo(aux.getTrasfondo());
        this.setAlineamiento(aux.getAlineamiento());
        this.setPx(aux.getPx());
        this.setBono_competencia(aux.getBono_competencia());
        this.setCaract(aux.getCaract());
    }

    /**
     * Método para crear un objeto de tipo Gson de una librería externa. El objeto de tipo Gson almacenará los atributos
     * del objeto de tipo ficha recogidos en el método anterior "ObtenerID" en un contenedor JSON.
     * @return devuelve el objeto de tipo String llamado json con los atributos del objeto de tipo ficha almacenado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String dameJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

    /**
     * Método para recibir el valor actual del atributo "FUE" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "FUE" de tipo "caracteristica".
     */
    public Caracteristica getFUE(){
    return Caract[0];
    }

    /**
     * Método para recibir el valor actual del atributo "DES" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "DES" de tipo "caracteristica".
     */
    public Caracteristica getDES(){
    return Caract[1];
    }

    /**
     * Método para recibir el valor actual del atributo "CON" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "CON" de tipo "caracteristica".
     */
    public Caracteristica getCON(){
    return Caract[2];
    }

    /**
     * Método para recibir el valor actual del atributo "INT" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "INT" de tipo "caracteristica".
     */
    public Caracteristica getINT(){
    return Caract[3];
    }

    /**
     * Método para recibir el valor actual del atributo "SAB" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "SAB" de tipo "caracteristica".
     */
    public Caracteristica getSAB(){
    return Caract[4];
    }

    /**
     * Método para recibir el valor actual del atributo "CAR" del objeto de tipo "caracteristica".
     * @return devuelve el valor de los atributos del objeto "CAR" de tipo "caracteristica".
     */
    public Caracteristica getCAR(){
    return Caract[5];
    }

    /**
     * Método para recibir el valor actual del atributo "idficha" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "idficha" del objeto de tipo "ficha".
     */
    public int getIdficha() {
        return idficha;
    }

    /**
     * Método para modificar el valor del atributo "idficha" del objeto de tipo "ficha".
     * @param idficha el nuevo valor que va a tener nuestro atributo "idficha" del objeto de tipo "ficha".
     */
    public void setIdficha(int idficha) {
        this.idficha = idficha;
    }

    /**
     * Método para recibir el valor actual del atributo "nombre" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "nombre" del objeto de tipo "ficha".
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el valor del atributo "nombre" del objeto de tipo "ficha".
     * @param nombre el nuevo valor que va a tener nuestro atributo "nombre" del objeto de tipo "ficha".
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para recibir el valor actual del atributo "nombrepj" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "nombrepj" del objeto de tipo "ficha".
     */
    public String getNombrepj() {
        return nombrepj;
    }

    /**
     * Método para modificar el valor del atributo "nombrepj" del objeto de tipo "ficha".
     * @param nombrepj el nuevo valor que va a tener nuestro atributo "nombrepj" del objeto de tipo "ficha".
     */
    public void setNombrepj(String nombrepj) {
        this.nombrepj = nombrepj;
    }

    /**
     * Método para recibir el valor actual del atributo "raza" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "raza" del objeto de tipo "ficha".
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Método para modificar el valor del atributo "raza" del objeto de tipo "ficha".
     * @param raza el nuevo valor que va a tener nuestro atributo "raza" del objeto de tipo "ficha".
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Método para recibir el valor actual del atributo "clase" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "clase" del objeto de tipo "ficha".
     */
    public String getClase() {
        return clase;
    }

    /**
     * Método para modificar el valor del atributo "clase" del objeto de tipo "ficha".
     * @param clase el nuevo valor que va a tener nuestro atributo "clase" del objeto de tipo "ficha".
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * Método para recibir el valor actual del atributo "nivel" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "nivel" del objeto de tipo "ficha".
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método para modificar el valor del atributo "nivel" del objeto de tipo "ficha".
     * @param nivel el nuevo valor que va a tener nuestro atributo "nivel" del objeto de tipo "ficha".
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método para recibir el valor actual del atributo "trasfondo" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "trasfondo" del objeto de tipo "ficha".
     */
    public String getTrasfondo() {
        return trasfondo;
    }

    /**
     * Método para modificar el valor del atributo "trasfondo" del objeto de tipo "ficha".
     * @param trasfondo el nuevo valor que va a tener nuestro atributo "trasfondo" del objeto de tipo "ficha".
     */
    public void setTrasfondo(String trasfondo) {
        this.trasfondo = trasfondo;
    }

    /**
     * Método para recibir el valor actual del atributo "alineamiento" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "alineamiento" del objeto de tipo "ficha".
     */
    public String getAlineamiento() {
        return alineamiento;
    }

    /**
     * Método para modificar el valor del atributo "alineamiento" del objeto de tipo "ficha".
     * @param alineamiento el nuevo valor que va a tener nuestro atributo "alineamiento" del objeto de tipo "ficha".
     */
    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    /**
     * Método para recibir el valor actual del atributo "px" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "px" del objeto de tipo "ficha".
     */
    public int getPx() {
        return px;
    }

    /**
     * Método para modificar el valor del atributo "px" del objeto de tipo "ficha".
     * @param px el nuevo valor que va a tener nuestro atributo "px" del objeto de tipo "ficha".
     */
    public void setPx(int px) {
        this.px = px;
    }

    /**
     * Método para recibir el valor actual del atributo "bono_competencia" del objeto de tipo "ficha".
     * @return devuelve el valor del atributo "bono_competencia" del objeto de tipo "ficha".
     */
    public int getBono_competencia() {
        return bono_competencia;
    }

    /**
     * Método para modificar el valor del atributo "bono_competencia" del objeto de tipo "ficha".
     * @param bono_competencia el nuevo valor que va a tener nuestro atributo "bono_competencia" del objeto de tipo "ficha".
     */
    public void setBono_competencia(int bono_competencia) {
        this.bono_competencia = bono_competencia;
    }

    /**
     * Método para recibir el valor actual del atributo "Caract" del objeto de tipo "caracteristica".
     * @return devuelve el valor del atributo "Caract" del objeto de tipo "caracteristica".
     */
    public Caracteristica[] getCaract() {
        return Caract;
    }

    /**
     * Método para modificar el valor del atributo "Caract" del objeto de tipo "caracteristica".
     * @param c el nuevo valor que va a tener nuestro atributo "Caract" del objeto de tipo "caracteristica".
     */
    public void setCaract(Caracteristica[] c) {
        Caract = c;
    }

    /**
     * Método para listar todos los atributos del objeto de tipo "ficha" de una manera clara y ordenada.
     * @return devuelve la lista de atributos del objeto de tipo "ficha".
     */
    @Override
    public String toString() {
        return "Ficha{" +
                "idficha:" + idficha +
                ", nombre:'" + nombre + '\'' +
                ", nombrepj:'" + nombrepj + '\'' +
                ", raza:" + raza +
                ", clase:" + clase +
                ", nivel:" + nivel +
                ", trasfondo:'" + trasfondo + '\'' +
                ", alineamiento:'" + alineamiento + '\'' +
                ", px:" + px +
                ", bono_competencia:" + bono_competencia +
                ", Caracteristicas=:" + Arrays.toString(Caract) +
                '}';
    }

}
