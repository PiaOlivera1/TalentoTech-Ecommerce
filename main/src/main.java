import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void Main(String[] args) {

        ProductoService servicio = new ProductoService();
        Scanner entrada = new Scanner(System.in);
        //int idSiguiente = productos.size()+1;

        System.out.println("*** Te damos la bienvenida a la app de compras ***");

        while (true) {
            System.out.println("""
                    Ingrese la opción deseada
                    0 - Finaliza el programa
                    1 - Crea un Producto
                    2 - Listar Productos
                    3 - Búsqueda por nombre
                    4 - Editar nombre producto
                    5 - Borrar producto
                    """);

            int opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 0 -> System.exit(0);
                case 1 -> servicio.crearProducto();
                case 2 -> servicio.listarProductos();
                case 3 -> servicio.busquedaPorNombre();
                case 4 -> servicio.editarNombreProducto();
                case 5 -> servicio.borrarProducto();
                default -> System.out.println("Opción inválida");
            }
        }

        //Producto mouse = new Producto("mouse logith", 10);


        //ArrayList<Producto> productos = new ArrayList<>();
    }
        
        public static void mostrarProductos(ArrayList<Producto> productos){
        for (Producto producto : productos){
            System.out.println(producto.toString());
        }


        }
}
