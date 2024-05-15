package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Clase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Gestion_clase", value = "/Gestion_clase")
public class Gestion_clase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recojo los datos de una tabla en la base de datos que ya está rellena y los pinto en el front.
        PrintWriter out = response.getWriter();
        String clase = request.getParameter("clase");
        Clase c = new Clase();
        try {
            c.listarClase(clase);
            System.out.println(c.claseJSON());
            out.print(c.claseJSON());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
