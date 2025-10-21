import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<String> productosDB = obtenerProductosTecnologicos();
        var entrada = new Scanner(System.in);
        int opcion;

        System.out.println("*** Te damos la bienvenida a la app de compras ***");
        label:
        while (true) {  // Bucle infinito: el menú se repite hasta que el usuario decida salir
            System.out.printf("""
                    Ingrese la opción deseada
                    0 - Finaliza el programa
                    1 - Crea un Producto
                    2 - Listar Productos
                    3 - Búsqueda por nombre
                    4 - Editar nombre producto
                    5 - Borrar producto
                    """);
            opcion = entrada.nextInt();  // Leemos la opción elegida

            switch (opcion) {
                case 1 -> crearProducto(productosDB);
                case 2 -> listarProductos(productosDB);
                case 3 -> BusquedaPorNombre(productosDB);
                case 4 -> EditarNombreProducto(productosDB);
                case 5 -> BorrarProducto(productosDB);


            }
        }
    }


    public static void crearProducto(ArrayList<String> productos) { //método para crear el nuevo producto
        var entrada = new Scanner(System.in);
        System.out.println("Creando nuevo producto ...");
        System.out.println("ingrese el nombre del producto: ");
        var nombre = entrada.nextLine();
        productos.add(nombre);   // agregamos el producto a la lista
        System.out.println("Producto agregado con exito!!");
    }

    public static void listarProductos(ArrayList<String> productos) //Listado de productos
    {
        System.out.println("***************************************");
        System.out.println("******* LISTADO DE PRODUCTOS **********");
        System.out.println("***************************************");

        // Verificamos si la lista está vacía o es nula
        if (productos == null || productos.isEmpty())
        {
            System.out.println("No hay productos para mostrar");
        }
        else
        {
            var contador = 1; // enumaromos los productos
            //For-each: recorre la lista completa de productos
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
        boolean encontrado = false;  // bandera para saber si lo encontramos
        // Limpiamos espacios y convertimos a minúscula para comparar sin errores
        nombre = nombre.trim().toLowerCase();
        for (String producto : productos){
            if (producto.toLowerCase().contains(nombre)){
                System.out.println("*** Producto encontrado: ***");
                System.out.println(producto);
                encontrado = true;
            }

        }
        if (!encontrado){
            System.out.println("No se encontro ningún producto");
        }

    }
    public static void EditarNombreProducto(ArrayList<String>productos){
        var entrada = new Scanner(System.in);
        System.out.println("Ingrese el producto que desea reemplazar:");
        var producto_existente = entrada.nextLine();
        boolean encontrado = false;
        producto_existente = producto_existente.trim().toLowerCase();  /// Quitamos espacios y pasamos todo a minúscula para comparar sin errores
        // Recorremos la lista completa de productos
        for (int i =0; i<productos.size(); i++){  ///  size recorre el tamaño de la lista

            String producto = productos.get(i); // obtenemos el producto actual en la posición i

            // Convertimos a minúscula para comparar sin importar mayúsculas/minúsculas
            if (producto.toLowerCase().contains(producto_existente)){
                encontrado= true;
                System.out.println("Ingrese el nuevo producto:");
                var producto_reemplazado = entrada.nextLine();
                productos.set(i, producto_reemplazado);  // Reemplazamos el producto anterior por el nuevo
                System.out.println("Producto reemplazado con Exito !!");
                break;// salimos del for una vez hecho el cambio
            }

            }
        if (!encontrado){
            System.out.println("No se encontro producto");
        }

    }
    public static void BorrarProducto(ArrayList<String> productos){
        var entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea eliminar: ");
        var producto_existente = entrada.nextLine();
        var encontrado = false;
        producto_existente = producto_existente.trim().toLowerCase();
        for (int i=0; i <productos.size(); i++){
            String producto = productos.get(i);
            if (!productos.isEmpty()){  // si el array no esta vacio entra al ciclo y busca el producto
                if (producto.toLowerCase().equals(producto_existente)){ // Comparamos nombres exactamente iguales
                    encontrado = true;
                    productos.remove(i); // eliminamos el producto en la posición i
                    System.out.println("Producto eliminado exitosamente");
                    break;
                }

            }
        }
        if (!encontrado){
            System.out.println("Producto inexistente");
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