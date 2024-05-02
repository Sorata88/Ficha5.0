package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Ficha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Crear_ficha", value = "/Crear_ficha")
public class Crear_ficha extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombrejugador");
        System.out.println(nombre);
        String nombrepj = request.getParameter("nombrepersonaje");
        System.out.println(nombrepj);
        int idraza = Integer.parseInt(request.getParameter("raza"));
        System.out.println(idraza);
        int idclase =Integer.parseInt(request.getParameter("clase"));
        System.out.println(idclase);
        int nivel = Integer.parseInt(request.getParameter("nivel"));
        System.out.println(nivel);
        String trasfondo = request.getParameter("trasfondo");
        System.out.println(trasfondo);
        String alineamiento = request.getParameter("alineamiento");
        System.out.println(alineamiento);
        int px = Integer.parseInt(request.getParameter("px"));
        System.out.println(px);

        Ficha n = new Ficha(nombre, nombrepj, idraza, idclase, nivel, trasfondo, alineamiento, px);
        System.out.println(n.toString());

        try {
            n.crear_ficha();
            response.sendRedirect("index.html");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creando ficha");
            throw new RuntimeException(e);
        }


    }
}
