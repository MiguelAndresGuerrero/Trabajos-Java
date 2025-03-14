import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrudTXT {
    private static String archivo = "./src/CRUD/data.txt";
    private static List<Persona> personas = new ArrayList<>();
    private static List<Producto>  productos = new ArrayList<>();

    // Cargar datos persistentes
    public static void cargarDatos() {
        personas.clear();
        productos.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while((linea=reader.readLine())!= null) {
                if(linea.startsWith("P,")) {
                    personas.add(Persona.fromString(linea));
                } else if (linea.startsWith("PR,")) {
                    productos.add(Producto.fromString(linea));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error al cargar archivo. Se procede a crear uno nuevo");
        }
    }

    public static void listarPersonas() {
        if(personas.isEmpty()) {
            System.out.println("No se pueden listar personas porque no existen");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }

    public static void listarProductos() {
        if(personas.isEmpty()) {
            System.out.println("No se pueden listar productos porque no existen");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}
