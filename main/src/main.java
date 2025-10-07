import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<String> productosDB = obtenerProductosTecnologicos();
        var entrada = new Scanner(System.in);
        int opcion;

        System.out.println("*** Te damos la bienvenida a la app de compras ***");
        label:
        while (true) {  //bucle infinito
            System.out.printf("""
                    Ingrese la opción deseada
                    0 - Finaliza el programa
                    1 - Crea un Producto
                    2 - Listar Productos
                    3 - Búsqueda por nombre
                    4 - Editar nombre producto
                    5 - Borrar producto
                    """);
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> crearProducto(productosDB);
                case 2 -> listarProductos(productosDB);
                case 3 -> BusquedaPorNombre(productosDB);

            }
        }
    }


    public static void crearProducto(ArrayList<String> productos) { //método para crear el nuevo producto
        var entrada = new Scanner(System.in);
        System.out.println("Creando nuevo producto ...");
        System.out.println("ingrese el nombre del producto: ");
        var nombre = entrada.nextLine();
        productos.add(nombre);
        System.out.println("Producto agregado con exito!!");
    }

    public static void listarProductos(ArrayList<String> productos) //Listado de productos
    {
        System.out.println("***************************************");
        System.out.println("******* LISTADO DE PRODUCTOS **********");
        System.out.println("***************************************");
        if (productos == null || productos.isEmpty())
        {
            System.out.println("No hay productos para mostrar");
        }
        else
        {
            var contador = 1;
            for (String producto : productos) {
                System.out.printf("%d - %s%n", contador, producto);
                contador++;
            }
        }
    }
    public static void BusquedaPorNombre(ArrayList<String> productos)
    {
        var entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a buscar: ");
        var nombre = entrada.nextLine();
        boolean encontrado = false;
        nombre = nombre.trim().toLowerCase();
        for (String producto : productos){
            if (producto.toLowerCase().contains(nombre)){
                System.out.println("*** Producto encontrado:");
                System.out.println(producto);
                encontrado = true;
            }
            if (!encontrado){
                System.out.println("No se encontro ningún producto");
            }
        }

    }


    public static ArrayList<String> obtenerProductosTecnologicos() {
        ArrayList<String> productos = new ArrayList<>();

        productos.add("Laptop Lenovo ThinkPad X1 Carbon");
        productos.add("Mouse inalámbrico Logitech MX Master 3");
        productos.add("Teclado mecánico Razer BlackWidow V4");
        productos.add("Monitor LG UltraWide 34 pulgadas");
        productos.add("Smartphone Samsung Galaxy S23 Ultra");
        productos.add("Tablet Apple iPad Pro 12.9\"");
        productos.add("Disco duro externo Seagate 2TB");
        productos.add("Memoria RAM Corsair Vengeance 16GB");
        productos.add("Cargador inalámbrico Belkin Boost Up");
        productos.add("Auriculares Bluetooth Sony WH-1000XM5");

        return productos;
    }

}