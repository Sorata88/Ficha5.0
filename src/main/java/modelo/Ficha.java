package modelo;

import DAO.DAOficha;

import java.sql.SQLException;

public class Ficha {

    private int idficha;
    private String nombre;
    private String nombrepj;
    private int idraza;
    private int idclase;
    private int nivel;
    private String trasfondo;
    private String alineamiento;
    private int px;

    public Ficha(int idficha, String nombre, String nombrepj, int idraza, int idclase, int nivel, String trasfondo, String alineamiento, int px) {
        this.idficha = idficha;
        this.nombre = nombre;
        this.nombrepj = nombrepj;
        this.idraza = idraza;
        this.idclase = idclase;
        this.nivel = nivel;
        this.trasfondo = trasfondo;
        this.alineamiento = alineamiento;
        this.px = px;
    }

    public Ficha(String nombre, String nombrepj, int idraza, int idclase, int nivel, String trasfondo, String alineamiento, int px) {
        this.nombre = nombre;
        this.nombrepj = nombrepj;
        this.idraza = idraza;
        this.idclase = idclase;
        this.nivel = nivel;
        this.trasfondo = trasfondo;
        this.alineamiento = alineamiento;
        this.px = px;
    }

    public int getIdficha() {
        return idficha;
    }

    public void setIdficha(int idficha) {
        this.idficha = idficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrepj() {
        return nombrepj;
    }

    public void setNombrepj(String nombrepj) {
        this.nombrepj = nombrepj;
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public int getIdclase() {
        return idclase;
    }

    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTrasfondo() {
        return trasfondo;
    }

    public void setTrasfondo(String trasfondo) {
        this.trasfondo = trasfondo;
    }

    public String getAlineamiento() {
        return alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                ", nombre='" + nombre + '\'' +
                ", nombrepj='" + nombrepj + '\'' +
                ", idraza=" + idraza +
                ", idclase=" + idclase +
                ", nivel=" + nivel +
                ", trasfondo='" + trasfondo + '\'' +
                ", alineamiento='" + alineamiento + '\'' +
                ", px=" + px +
                '}';
    }

    public void crear_ficha() throws SQLException {
        DAOficha.getInstance().crear_ficha(this);
    }
}
