package jdbc.NORMALITO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    // Atributos a la base de datos
    // jdbc: mysql://host:puerto/basededatos
    private String URL = "jdbc:mysql://bj998wxdzi2ajvbulneb-mysql.services.clever-cloud.com:3306/bj998wxdzi2ajvbulneb";
    private String USER = "unbrzjbutjd0oi9g";
    private String PASS = "bkqn0vf76R0Ax59xnwZG";
    
    // Metodo para conectarnos a la base de datos
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Crear insert
    public void insertarUsuario(String nombre, String email){
        String sql = "INSERT INTO usuarios VALUES (?, ?)";
        try(
            Connection conexionInterna = conectar();
            PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            //Asignando valores a las incognitas
            solicitud.setString(1, nombre);
            solicitud.setString(2, email);
            //Ejecucion de la solicitud
            solicitud.executeUpdate();
            System.out.println("Registro insertado exitosamente");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    // Leer (select)
    // select * from usuarios;
    public List<String> obtenerUsuarios(){
        String sql = "select * from usuarios";
        List<String> listaUsuarios = new ArrayList<>();
        try(
                Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql);
                ResultSet resultado = solicitud.executeQuery();){
            while (resultado.next()){
                listaUsuarios.add(resultado.getInt("id") +
                        " - " + resultado.getString("nombre")+  " - " +
                        resultado.getString("email"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    //Actualizar (Update)
    // update usuarios set nombre = pedrito, email = pedrito@gmail.com where id = 3
    public void actualizarUsuario(int id, String nombre,String email){
        String sql = "update usuarios set nombre=?, email=? where id= ?";
        try(
                Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            //Asignando valores a las incógnitas
            solicitud.setString(1, nombre);
            solicitud.setString(2, email);
            solicitud.setInt(3, id);
            //Ejecución de la solicitud
            int filas = solicitud.executeUpdate();
            if(filas > 0){
                System.out.println("Usuario actualizado exitosamente!");
            }else{
                System.out.println("No se pudo actualizar el usuario con ID "+id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
