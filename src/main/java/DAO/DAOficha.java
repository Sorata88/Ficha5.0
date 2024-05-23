package DAO;

import modelo.Ficha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * Clase DAO (Data Access Objet) de la clase ficha. Permite encapsular toda la lógica de acceso a datos del resto de
 * la aplicación.
 * Todos los atributos de esta clase son privados y por tanto no aparecerán en la documentación.
 * @author AOG.
 * @version 1.0.0
 */
public class DAOficha {

    private Connection conn = null;
    private static DAOficha instance = null;

    /**
     *
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public DAOficha() throws SQLException {
        conn = DBconnection.getConnection();
    }

    /**
     * Método que implementa el patrón de diseño "Singleton" para la clase ficha. Sólo permite una instancia de la
     * clase para toda la aplicación. Si no existe, creará el objeto, en caso contrario, lo invocará desde la memoria.
     * @return devuelve el objeto DAO de la clase ficha.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public static DAOficha getInstance() throws SQLException {
        if(instance == null){
            instance = new DAOficha();
        }
        return instance;
    }

    /**
     * Método para insertar un nuevo objeto de tipo ficha en la base de datos.
     * @param n objeto de tipo ficha que le pasamos al método como parámetro.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void crear_ficha(Ficha n) throws SQLException{

        String query = "INSERT INTO ficha (idficha, nombre, nombrepj, raza, clase, nivel, trasfondo, alineamiento, px, bono_competencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, n.getIdficha());
            ps.setString(2, n.getNombre());
            ps.setString(3, n.getNombrepj());
            ps.setString(4, n.getRaza());
            ps.setString(5, n.getClase());
            ps.setInt(6, n.getNivel());
            ps.setString(7, n.getTrasfondo());
            ps.setString(8, n.getAlineamiento());
            ps.setInt(9, n.getPx());
            ps.setInt(10, n.getBono_competencia());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            n.setIdficha(rs.getInt(1));

            ps.close();
        }

        insertarCaract(n.getIdficha(), n.getFUE().getIdCaract(), n.getFUE().getPuntuacion(), n.getFUE().getModificador());

        insertarCaract(n.getIdficha(), n.getDES().getIdCaract(), n.getDES().getPuntuacion(), n.getDES().getModificador());

        insertarCaract(n.getIdficha(), n.getCON().getIdCaract(), n.getCON().getPuntuacion(), n.getCON().getModificador());

        insertarCaract(n.getIdficha(), n.getINT().getIdCaract(), n.getINT().getPuntuacion(), n.getINT().getModificador());

        insertarCaract(n.getIdficha(), n.getSAB().getIdCaract(), n.getSAB().getPuntuacion(), n.getSAB().getModificador());

        insertarCaract(n.getIdficha(), n.getCAR().getIdCaract(), n.getCAR().getPuntuacion(), n.getCAR().getModificador());
    }

    /**
     * Método para insertar los objetos de tipo caracteristica en la base de datos en una tabla relacional para un
     * objeto de tipo ficha determinado.
     * @param idFicha atributo idficha que relaciona los objetos caracteristica con un objeto ficha.
     * @param idCaract atributo identificador único de cada objeto de tipo caracteristica.
     * @param punt atributo puntuacion para el objeto de tipo caracteristica.
     * @param mod atributo modificador para el objeto de tipo caracteristica.
     */
    public void insertarCaract( int idFicha, int idCaract, int punt, int mod){
        String query = "INSERT INTO caracteristica_ficha (idficha, idcaract, puntuacion, modificador) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idFicha);
            ps.setInt(2, idCaract);
            ps.setInt(3, punt);
            ps.setInt(4, mod);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para actualizar los atributos de un objeto de tipo caracteristica concreto para un objeto de tipo ficha
     * en particular.
     * @param idFicha atributo idficha que relaciona los objetos caracteristica con un objeto ficha.
     * @param idCaract atributo identificador único de cada objeto de tipo caracteristica.
     * @param punt atributo puntuacion para el objeto de tipo caracteristica.
     * @param mod atributo modificador para el objeto de tipo caracteristica.
     */
    public void actualizarCaract( int idFicha, int idCaract, int punt, int mod){
        String query = "UPDATE caracteristica_ficha SET puntuacion=?, modificador=? WHERE idficha=? and idcaract=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, punt);
            ps.setInt(2, mod);
            ps.setInt(3, idFicha);
            ps.setInt(4, idCaract);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Método para recoger todos los objetos de tipo ficha de la base de datos y almacenarlos en un "array" de fichas.
     * @return devuelve el "array" de objetos de tipo ficha.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public ArrayList<Ficha> listar_ficha() throws SQLException{

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ficha");
        ResultSet rs = ps.executeQuery();

        ArrayList<Ficha> lista_ficha = null;
        while(rs.next()) {
            if(lista_ficha == null) {
                lista_ficha = new ArrayList<>();
            }
            lista_ficha.add(new Ficha(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                    rs.getString(8), rs.getInt(9), rs.getInt(10)));
        }
        return lista_ficha;
    }

    /**
     * Método para recoger todos los objetos de tipo ficha de la base de datos con un atributo "nombre" determinado
     * y almacenarlos en un "array" de fichas.
     * @param nombre atributo nombre del objeto de tipo ficha que queremos usar para filtrar.
     * @return devuelve el "array" de objetos de tipo ficha.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public ArrayList<Ficha> listar_ficha_usuario(String nombre) throws SQLException{

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ficha WHERE nombre=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();

        ArrayList<Ficha> lista_ficha_usuario = null;
        while(rs.next()) {
            if(lista_ficha_usuario == null) {
                lista_ficha_usuario = new ArrayList<>();
            }
            lista_ficha_usuario.add(new Ficha(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                    rs.getString(8), rs.getInt(9), rs.getInt(10)));
        }
        return lista_ficha_usuario;
    }

    /**
     * Método para convertir el "array" de objetos de tipo ficha recuperado en el método "listar_ficha_usuario" anterior.
     * @param nombre atributo del objeto de tipo ficha que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo String con todos los datos del array en formato JSON.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String tomaJSON(String nombre) throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar_ficha_usuario(nombre));
        return json;
    }

    /**
     * Método para convertir el "array" de objetos de tipo ficha recuperado en el método "listar_ficha" anterior.
     * @return devuelve el objeto de tipo String con todos los datos del array en formato JSON.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public String listarJSON() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar_ficha());
        return json;
    }

    /**
     * Método para recuperar un objeto concreto de tipo ficha de la base de datos usando su identificador único.
     * @param id atributo del objeto de tipo ficha que le pasamos al método como parámetro.
     * @return devuelve el objeto de tipo ficha deseado.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public Ficha obtenerID(int id) throws SQLException{
        String query = "SELECT * FROM ficha WHERE idficha = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Ficha n = new Ficha(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                rs.getString(8), rs.getInt(9), rs.getInt(10));

        String query2 = "SELECT * FROM caracteristica_ficha WHERE idficha = ?";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setInt(1, id);
        ResultSet rs2 = ps2.executeQuery();
        while(rs2.next()){
            n.setCaract(rs2.getInt(2),rs2.getInt(3),rs2.getInt(4));
        }
        return n;
    }

    /**
     * Método para actualizar los datos (atributos) de un objeto de tipo ficha ya existente en la base de datos.
     * @param n objeto de tipo ficha que le pasamos al método como parámentro.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void actualizarFicha(Ficha n) throws SQLException{

        String query = "UPDATE ficha SET nombre=?, nombrepj=?, raza=?, clase=?, nivel=?, trasfondo=?, alineamiento=?, px=?, bono_competencia=? WHERE idficha=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, n.getNombre());
            ps.setString(2, n.getNombrepj());
            ps.setString(3, n.getRaza());
            ps.setString(4, n.getClase());
            ps.setInt(5, n.getNivel());
            ps.setString(6, n.getTrasfondo());
            ps.setString(7, n.getAlineamiento());
            ps.setInt(8, n.getPx());
            ps.setInt(9, n.getBono_competencia());
            ps.setInt(10, n.getIdficha());

            ps.executeUpdate();
            ps.close();
        }
        actualizarCaract(n.getIdficha(), n.getFUE().getIdCaract(), n.getFUE().getPuntuacion(), n.getFUE().getModificador());

        actualizarCaract(n.getIdficha(), n.getDES().getIdCaract(), n.getDES().getPuntuacion(), n.getDES().getModificador());

        actualizarCaract(n.getIdficha(), n.getCON().getIdCaract(), n.getCON().getPuntuacion(), n.getCON().getModificador());

        actualizarCaract(n.getIdficha(), n.getINT().getIdCaract(), n.getINT().getPuntuacion(), n.getINT().getModificador());

        actualizarCaract(n.getIdficha(), n.getSAB().getIdCaract(), n.getSAB().getPuntuacion(), n.getSAB().getModificador());

        actualizarCaract(n.getIdficha(), n.getCAR().getIdCaract(), n.getCAR().getPuntuacion(), n.getCAR().getModificador());
    }

    /**
     * Método para eliminar un objeto de tipo ficha de la base de datos.
     * @param idficha el atributo identificativo de la ficha que queremos borrar.
     * @throws SQLException lanza una excepción de tipo SQL.
     */
    public void borrarFicha(int idficha) throws SQLException {
        String query = "DELETE FROM caracteristica_ficha WHERE idficha=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idficha);
        ps.executeUpdate();
        String query2 = "DELETE FROM ficha WHERE idficha=?";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setInt(1, idficha);
        ps2.executeUpdate();
        ps.close();
        ps2.close();
    }
}
