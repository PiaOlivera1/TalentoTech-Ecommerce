import java.util.ArrayList;
import java.util.Scanner;


public class ProductoService {

        private ArrayList<Producto> productos;
        private Scanner entrada = new Scanner(System.in);

        public ProductoService() {
            productos = obtenerProductosTecnologicos();
        }
    public void crearProducto()
    { //método para crear el nuevo producto
        System.out.println("Creando nuevo producto ...");
        System.out.println("ingrese el nombre del producto: ");
        var nombre = entrada.nextLine();
        productos.add(new Producto(nombre));   // agregamos el producto a la lista
        System.out.println("Producto agregado con exito!!");
    }

    public void listarProductos() //Listado de productos
    {
        System.out.println("***************************************");
        System.out.println("******* LISTADO DE PRODUCTOS **********");
        System.out.println("***************************************");

        // Verificamos si la lista está vacía o es nula
        if (productos.isEmpty())
        {
            System.out.println("No hay productos para mostrar");
        }
        else
        {
            var contador = 1; // enumaromos los productos
            //For-each: recorre la lista completa de productos
            for (Producto producto : productos) {
                System.out.println(contador + " - " + producto.getNombre());
                contador++;
            }
        }
    }
    public void busquedaPorNombre()
    {
        var entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a buscar: ");
        var nombre = entrada.nextLine();
        boolean encontrado = false;  // bandera para saber si lo encontramos
        // Limpiamos espacios y convertimos a minúscula para comparar sin errores
        nombre = nombre.trim().toLowerCase();
        for (Producto producto : productos){
            if (producto.getNombre().toLowerCase().contains(nombre)){
                System.out.println("*** Producto encontrado: ***");
                System.out.println(producto);
                encontrado = true;
            }

        }
        if (!encontrado){
            System.out.println("No se encontro ningún producto");
        }

    }
    public void editarNombreProducto(){

        System.out.print("Ingrese el nombre del producto que desea editar: ");
        String nombreBuscado = entrada.nextLine().trim().toLowerCase();

        boolean encontrado = false;

        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombreBuscado)) {
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = entrada.nextLine();
                p.setNombre(nuevoNombre);
                System.out.println("Producto modificado con éxito!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

    }
    public void borrarProducto(){
        System.out.print("Ingrese el nombre del producto que desea eliminar: ");
        String nombreBuscado = entrada.nextLine().trim().toLowerCase();

        boolean eliminado = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().toLowerCase().equals(nombreBuscado)) {
                productos.remove(i);
                System.out.println("Producto eliminado con éxito.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("Producto inexistente.");
        }
    }

    public static ArrayList<Producto> obtenerProductosTecnologicos() {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Laptop Lenovo ThinkPad X1 Carbon"));
        productos.add(new Producto("Mouse inalámbrico Logitech MX Master 3"));
        productos.add(new Producto("Teclado mecánico Razer BlackWidow V4"));
        productos.add(new Producto("Monitor LG UltraWide 34 pulgadas"));
        productos.add(new Producto("Smartphone Samsung Galaxy S23 Ultra"));
        productos.add(new Producto("Tablet Apple iPad Pro 12.9"));
        productos.add(new Producto("Disco duro externo Seagate 2TB"));
        productos.add(new Producto("Memoria RAM Corsair Vengeance 16GB"));
        productos.add(new Producto("Cargador inalámbrico Belkin Boost Up"));
        productos.add(new Producto("Auriculares Bluetooth Sony WH-1000XM5"));

        return productos;
    }
}
