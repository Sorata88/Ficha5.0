package controlador;

import DAO.DAOficha;
import DAO.DAOusuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Ficha;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Gestion_usuario", value = "/Gestion_usuario")
public class Gestion_usuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        int opcion = Integer.parseInt(request.getParameter("op"));

        if (opcion == 1) { //Listar usuarios desde la base de datos.
            try {
                String recogerJSON = DAOusuario.getInstance().listarJSON();
                out.print(recogerJSON);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (opcion == 2) { //Editar usuarios existentes.
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario u = new Usuario();
            try {
                u.obtenerID(id);
                out.print(u.dameJSON());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (opcion == 3) { //Borrar un usuario de la lista.
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario u = new Usuario();
            try {
                u.borrarUsuario(id);
                String recogerJSON = DAOusuario.getInstance().listarJSON();
                out.print(recogerJSON);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id_usuario");
        String nickname = request.getParameter("nickname");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        int nivel_permiso = 5;
        String hash_pass = Usuario.getMD5(password);


        Usuario u = new Usuario(nickname, correo, hash_pass, nivel_permiso);
        System.out.println(u.toString());


        try { //Si el id está vacío, creará un nuevo usuario.
            if (id == ""){
                u.crear_usuario();
                response.sendRedirect("auxiliar.html"); //Me manda al index tras terminar.
            } else { //En caso contrario, editará al usuario a la que pertenece ese id.
                int idusuario = Integer.parseInt(id);
                u.setIdusuario(idusuario);
                u.actualizarUsuario();
                response.sendRedirect("index.html"); //Me manda al index tras terminar.
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creando usuario"); //Me salta un error en el back en caso de fallo al crear.
            throw new RuntimeException(e);
        }
    }
}
