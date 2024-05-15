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


@WebServlet(name = "Gestion_ficha", value = "/Gestion_ficha")
public class Gestion_ficha extends HttpServlet {
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
                System.out.println(n.dameJSON());
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
        } else if(opcion == 4) {
            int id = Integer.parseInt(request.getParameter("idficha"));
            Ficha n = new Ficha();
            try {
                n.obtenerID(id);
                out.print(n.dameJSON());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("idficha");
        String nombre = request.getParameter("nombrejugador");
        String nombrepj = request.getParameter("nombrepersonaje");
        String raza = request.getParameter("raza");
        String clase = request.getParameter("clase");
        int nivel = Integer.parseInt(request.getParameter("nivel"));
        String trasfondo = request.getParameter("trasfondo");
        String alineamiento = request.getParameter("alineamiento");
        int px = Integer.parseInt(request.getParameter("px"));
        int bono = Integer.parseInt(request.getParameter("bono_competencia"));

        Ficha n = new Ficha(nombre, nombrepj, raza, clase, nivel, trasfondo, alineamiento, px, bono);

        n.setCaract(1, Integer.parseInt(request.getParameter("FUE")), Integer.parseInt(request.getParameter("mod_fuerza")));
        n.setCaract(2, Integer.parseInt(request.getParameter("DES")), Integer.parseInt(request.getParameter("mod_destreza")));
        n.setCaract(3, Integer.parseInt(request.getParameter("CON")), Integer.parseInt(request.getParameter("mod_constitucion")));
        n.setCaract(4, Integer.parseInt(request.getParameter("INT")), Integer.parseInt(request.getParameter("mod_inteligencia")));
        n.setCaract(5, Integer.parseInt(request.getParameter("SAB")), Integer.parseInt(request.getParameter("mod_sabiduria")));
        n.setCaract(6, Integer.parseInt(request.getParameter("CAR")), Integer.parseInt(request.getParameter("mod_carisma")));

        try {
            if (id == ""){
                n.crear_ficha();
            } else {
                int idficha = Integer.parseInt(id);
                n.setIdficha(idficha);
                n.actualizarFicha();
            }

            response.sendRedirect("listar.html");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creando ficha");
            throw new RuntimeException(e);
        }

    }
}
