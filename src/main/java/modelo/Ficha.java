package modelo;

import DAO.DAOficha;

import java.sql.SQLException;
import java.util.Arrays;

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
    private Caracteristica Caract[] = new Caracteristica[6];

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
        inicializar();
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
        inicializar();

    }

    private void inicializar(){
        Caract[0] = new Caracteristica("Fuerza",1);
        Caract[1] = new Caracteristica("Destreza",2);
        Caract[2] = new Caracteristica("Constitución",3);
        Caract[3] = new Caracteristica("Inteligencia",4);
        Caract[4] = new Caracteristica("Sabiduría",5);
        Caract[5] = new Caracteristica("Carisma",6);
    }

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

    public Caracteristica getFUE(){
    return Caract[0];
    }

    public Caracteristica getDES(){
    return Caract[1];
    }

    public Caracteristica getCON(){
    return Caract[2];
    }

    public Caracteristica getINT(){
    return Caract[3];
    }

    public Caracteristica getSAB(){
    return Caract[4];
    }

    public Caracteristica getCAR(){
    return Caract[5];
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

    public Caracteristica[] getC() {
        return Caract;
    }

    public void setC(Caracteristica[] c) {
        Caract = c;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "idficha=" + idficha +
                ", nombre='" + nombre + '\'' +
                ", nombrepj='" + nombrepj + '\'' +
                ", idraza=" + idraza +
                ", idclase=" + idclase +
                ", nivel=" + nivel +
                ", trasfondo='" + trasfondo + '\'' +
                ", alineamiento='" + alineamiento + '\'' +
                ", px=" + px +
                ", C=" + Arrays.toString(Caract) +
                '}';
    }

    public void crear_ficha() throws SQLException {
        DAOficha.getInstance().crear_ficha(this);
    }
}
