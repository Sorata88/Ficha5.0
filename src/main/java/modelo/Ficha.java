package modelo;

import DAO.DAOficha;

import java.sql.SQLException;

public class Ficha {

    private int idficha;
    private int idjugador;
    private String nombre;
    private String nombrepj;
    private int idraza;
    private int idclase;
    private int nivel;
    private String trasfondo;
    private int alineamiento;
    private int xp;
    private int bono_competencia;

    public Ficha() {
    }

    public Ficha(int idficha, int idjugador, String nombre, String nombrepj, int idraza, int idclase, int nivel,
                 String trasfondo, int alineamiento, int xp, int bono_competencia) {
        this.idficha = idficha;
        this.idjugador = idjugador;
        this.nombre = nombre;
        this.nombrepj = nombrepj;
        this.idraza = idraza;
        this.idclase = idclase;
        this.nivel = nivel;
        this.trasfondo = trasfondo;
        this.alineamiento = alineamiento;
        this.xp = xp;
        this.bono_competencia = bono_competencia;
    }

    public Ficha(String nombre, String nombrepj, int idraza, int idclase, int nivel, int alineamiento, String trasfondo,
                 int xp, int bono_competencia) {
        this.nombre = nombre;
        this.idraza = idraza;
        this.idclase = idclase;
        this.nivel = nivel;
        this.alineamiento = alineamiento;
        this.trasfondo = trasfondo;
        this.xp = xp;
        this.bono_competencia = bono_competencia;
    }

    public int getIdficha() {
        return idficha;
    }

    public int getIdjugador() {
        return idjugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombrepj() {
        return nombrepj;
    }

    public int getIdraza() {
        return idraza;
    }

    public int getIdclase() {
        return idclase;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTrasfondo() {
        return trasfondo;
    }

    public int getAlineamiento() {
        return alineamiento;
    }

    public int getXp() {
        return xp;
    }

    public int getBono_competencia() {
        return bono_competencia;
    }

    public void setIdficha(int idficha) {
        this.idficha = idficha;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombrepj(String nombrepj) {
        this.nombrepj = nombrepj;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTrasfondo(String trasfondo) {
        this.trasfondo = trasfondo;
    }

    public void setAlineamiento(int alineamiento) {
        this.alineamiento = alineamiento;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setBono_competencia(int bono_competencia) {
        this.bono_competencia = bono_competencia;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "idficha=" + idficha +
                ", idjugador=" + idjugador +
                ", nombre='" + nombre + '\'' +
                ", nombrepj='" + nombrepj + '\'' +
                ", idraza=" + idraza +
                ", idclase=" + idclase +
                ", nivel=" + nivel +
                ", trasfondo='" + trasfondo + '\'' +
                ", alineamiento=" + alineamiento +
                ", xp=" + xp +
                ", bono_competencia=" + bono_competencia +
                '}';
    }

    public void crear_ficha() throws SQLException {
        DAOficha.getInstance().crear_ficha(this);
    }
}
