package jdbc;

import jdbc.NORMALITO.UsuarioDAO;
import java.util.List;

public class main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insertarUsuario("Zully", "Zully@gmail.com");
        usuarioDAO.insertarUsuario("pedro", "pedrogomez@gmail.com");
        usuarioDAO.insertarUsuario("Valentina", "Valentina@gmail.com");

        List<String> ListaUsuarios = usuarioDAO.obtenerUsuarios();
        for(String usuario : listaUsuarios) {
            System.out.println(usuario);
        }
        usuarioDAO.actualizarUsuario(3, "jaime", "jaime@gmail.com");
        listaUsuarios = usuarioDAO.obtenerUsuarios();
        System.out.println("#############################");
        for (String usuario : ListaUsuarios) {
            System.out.println(usuario);
        }
    }
}
