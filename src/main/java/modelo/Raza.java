package modelo;

import DAO.DAOraza;
import com.google.gson.Gson;

import java.sql.SQLException;

public class Raza {

    private int idraza;
    private String nombre;
    private String mejora_leve;
    private String mejora_moderada;
    private String size;
    private String velocidad;
    private String idiomas;
    private String atributo_racial;

    public Raza() {
    }

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

    public Raza(String nombre, String mejora_leve, String mejora_moderada, String size, String velocidad, String idiomas, String atributo_racial) {
        this.nombre = nombre;
        this.mejora_leve = mejora_leve;
        this.mejora_moderada = mejora_moderada;
        this.size = size;
        this.velocidad = velocidad;
        this.idiomas = idiomas;
        this.atributo_racial = atributo_racial;
    }

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

    public String razaJSON(){
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
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

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getAtributo_racial() {
        return atributo_racial;
    }

    public void setAtributo_racial(String atributo_racial) {
        this.atributo_racial = atributo_racial;
    }

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
