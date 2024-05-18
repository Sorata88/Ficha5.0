package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "Gestion_login", value = "/Gestion_login")
public class Gestion_login extends HttpServlet {
    HttpSession sesion;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opt");

        HttpSession sesion = request.getSession(false);
            if (sesion != null) {
                if (opcion.equals("acceso")){
                    int permiso = (int)sesion.getAttribute("permiso");
                    response.getWriter().write(String.valueOf(permiso));
                } else if (opcion.equals("username")){
                    String username = (String) sesion.getAttribute("nickname");
                    response.getWriter().write(String.valueOf(username));
                }
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        Usuario u = new Usuario();

        u.setNickname(usuario);
        u.setPassword(Usuario.getMD5(contrasena));

        try {
            if(u.log_in()){
                sesion = request.getSession();
                sesion.setAttribute("nickname", u.getNickname());
                sesion.setAttribute("permiso", u.getPermiso());

                response.sendRedirect("index.html");
            } else {
                response.sendRedirect("login-registro.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
