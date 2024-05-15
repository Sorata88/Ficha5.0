package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Raza;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Gestion_raza", value = "/Gestion_raza")
public class Gestion_raza extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recojo los datos de una tabla en la base de datos que ya está rellena y los pinto en el front.
        PrintWriter out = response.getWriter();
        String raza = request.getParameter("raza");
        Raza r = new Raza();
        try {
            r.listarRaza(raza);
            System.out.println(r.razaJSON());
            out.print(r.razaJSON());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
