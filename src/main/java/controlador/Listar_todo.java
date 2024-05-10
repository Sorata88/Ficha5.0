package controlador;

import DAO.DAOficha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Ficha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Listar_todo", value = "/Listar_todo")
public class Listar_todo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        int opcion = Integer.parseInt(request.getParameter("op"));

        if (opcion == 1) {
            try {
                String recogerJSON = DAOficha.getInstance().listarJSON();
                out.print(recogerJSON);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (opcion == 2) {
            int id = Integer.parseInt(request.getParameter("idficha"));
            Ficha n = new Ficha();
            try {
                n.obtenerID(id);
                out.print(n.dameJSON());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (opcion == 3) {
            int id = Integer.parseInt(request.getParameter("idficha"));
            Ficha n = new Ficha();
            try {
                n.borrarFicha(id);
                String recogerJSON = DAOficha.getInstance().listarJSON();
                out.print(recogerJSON);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
