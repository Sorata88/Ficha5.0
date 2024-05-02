package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public static final String url = "jdbc:mysql://localhost:3306/dnd_ficha";
    private static final String user = "root";
    private static final String password = "1234+";
    private static Connection con=null;

    public static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void closeConnection() throws SQLException {
        if(con!=null){
            con.close();
        }
    }


}
