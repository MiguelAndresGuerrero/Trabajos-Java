package jdbc;

import jdbc.NORMALITO.UsuarioDAO;
import java.util.List;

public class main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertar usuarios
        /*
        usuarioDAO.insertarUsuario("Zully", "Zully@gmail.com");
        usuarioDAO.insertarUsuario("Pedro", "pedrogomez@gmail.com");
        usuarioDAO.insertarUsuario("Valentina", "Valentina@gmail.com");
            */
        // Obtener y mostrar usuarios
        List<String> listaUsuarios = usuarioDAO.obtenerUsuarios();
        for (String usuario : listaUsuarios) {
            System.out.println(usuario);
        }

        // Actualizar usuario con ID 3
        usuarioDAO.actualizarUsuario(3, "Jaime", "jaime@gmail.com");

        // Obtener y mostrar usuarios después de la actualización
        listaUsuarios = usuarioDAO.obtenerUsuarios();
        System.out.println("#############################");
        System.out.println("Usuarios actualizados");
        for (String usuario : listaUsuarios) {
            System.out.println(usuario);
        }

        // Obtener y mostrar el usuario eliminado
        System.out.println("###############################");
        usuarioDAO.eliminarUsuario(6);
        System.out.println(usuarioDAO.obtenerUsuarios());

        // Obtener y mostrar los usuarios por id
        System.out.println("###############################");
        System.out.println("Usuarios por id");
        usuarioDAO.buscarIdUsuarios();
    }
}