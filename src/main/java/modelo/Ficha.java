package modelo;

import DAO.DAOficha;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.Arrays;

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

    public Ficha() {
    }

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

    public void crear_ficha() throws SQLException {
        DAOficha.getInstance().crear_ficha(this);
    }

    public void actualizarFicha() throws SQLException {
        DAOficha.getInstance().actualizarFicha(this);
    }

    public void borrarFicha(int id) throws SQLException {
        DAOficha.getInstance().borrarFicha(id);
    }

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

    public String dameJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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

    public int getBono_competencia() {
        return bono_competencia;
    }

    public void setBono_competencia(int bono_competencia) {
        this.bono_competencia = bono_competencia;
    }

    public Caracteristica[] getCaract() {
        return Caract;
    }

    public void setCaract(Caracteristica[] c) {
        Caract = c;
    }

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
