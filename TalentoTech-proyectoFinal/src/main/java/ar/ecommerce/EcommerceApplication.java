package ar.ecommerce;

import ar.ecommerce.modelo.Producto;
import ar.ecommerce.servicio.IProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class  EcommerceApplication implements CommandLineRunner {

    @Autowired
    private IProductoServicio productoServicio;

    private static final Logger logger = //Logger seria como usar print
                 LoggerFactory.getLogger(EcommerceApplication.class);


	public static void main(String[] args) {
        logger.info("Iniciando la aplicación");
        //levanta la fabrica de spting
        SpringApplication.run(EcommerceApplication.class, args);
        logger.info("Aplicación finalizada");
	}

    @Override
    public void run(String... args) throws Exception { //es como el método main
        logger.info("**** Aplicacion de tienda virtual ****");
        Scanner entrada = new Scanner(System.in);
        var salir = false;

        while (!salir) {
            var opcion = mostrarMenu(entrada);
            salir = ejecutarOpciones(entrada, opcion);

        }
    }
    private int mostrarMenu( Scanner entrada){
        logger.info("""
                    Ingrese la opción deseada
                    0 - Finaliza el programa
                    1 - Listar Productos
                    2 - Búsqueda por Id
                    3 - Agregar un Producto
                    4 - Editar producto por ID
                    5 - Borrar producto
                    6 - Salir
                    """);
        return Integer.parseInt(entrada.nextLine());
    }
    private boolean ejecutarOpciones(Scanner entrada, int opcion){
        var salir = false;
        switch (opcion) {
            case 0 -> System.exit(0);
            case 1 -> {
                    logger.info("--- Listado de productos: ---");
                    List<Producto> productos = productoServicio.listarProductos();
                    productos.forEach(producto -> logger.info(producto.toString()));
            }

            case 2 -> {
                logger.info("-- Busqueda del producto por Id: --");
                var idProducto =Integer.parseInt(entrada.nextLine());
                Producto producto = productoServicio.buscarProductoPorId(idProducto);
                if(producto!= null){
                    logger.info("Producto encontrado: "+producto);
                }else {
                    logger.info("Producto no encontrado: "+producto);
                }
            }
            case 3-> {
                logger.info("--- Agregar un producto --- ");
                var agregado = new Producto();
                logger.info("Ingrese el nombre del producto: ");
                agregado.setNombre(entrada.nextLine());
                logger.info("Agrege el precio del producto: ");
                agregado.setPrecio(entrada.nextDouble());
                entrada.nextLine();
                logger.info("Agregue la descripción del producto: ");
                agregado.setDescripcion(entrada.nextLine());

                logger.info("Agrege la categoria del producto");
                agregado.setCategoria(entrada.nextLine());
                productoServicio.agregarProducto(agregado);
                logger.info("Priducto agregado correctamente: "+agregado);
            }

            case 4 -> {
                logger.info("---- Modificar el producto por id ---- ");
                var productomodificado = new Producto();
                logger.info("ingrese el id del producto que desea modificar: ");
                var id = entrada.nextInt();
                productomodificado = productoServicio.buscarProductoPorId(id);
                entrada.nextLine();
                if (productomodificado!= null){
                    logger.info("Nombre: ");
                    productomodificado.setNombre(entrada.nextLine());
                    logger.info("Precio: ");
                    productomodificado.setPrecio(entrada.nextDouble());
                    entrada.nextLine();
                    logger.info("Descripcion: ");
                    productomodificado.setDescripcion(entrada.nextLine());
                    logger.info("Categoria: ");
                    productomodificado.setCategoria(entrada.nextLine());
                    productoServicio.modificarProducto(productomodificado);
                    logger.info("Producto modificado con Exito !!!");
                }
                else{
                    logger.info("Producto no encontrado "+productomodificado);
                }

            }

            case 5-> {
                logger.info("--- Elimina el producto por ID ---");
                var eliminado = new Producto();
                logger.info("Ingresa el id del producto a eliminar: ");
                var id = entrada.nextInt();
                entrada.nextLine(); //limpiamos el buffer

                eliminado = productoServicio.buscarProductoPorId(id);
                if (eliminado != null){
                    productoServicio.eliminarProducto(eliminado);
                    logger.info("Producto eliminado con exito!!" +eliminado);
                }
                else{
                    logger.info("No se encontro producto: "+eliminado);
                }


            }
            case 6 -> {
                logger.info("HASTA PRONTO !");
                salir = true;
            }


        }
        return salir;
    }
}
