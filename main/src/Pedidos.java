import java.util.ArrayList;

public class Pedidos {

    private int contadorProductos;
    private ArrayList<ProductoCarrito> productos;

    public Pedidos(){
        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoCarrito producto){
        productos.add(producto);
    }

    public double calcularPrecioTotal(){
        double total=0;

        for (ProductoCarrito producto : productos){
            //total += producto;
            pause;
        }
        return total;
    }

    public void listarProductos(){
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el pedido");
            return;
        }
        for (ProductoCarrito producto : productos){
            System.out.println(producto.getNombre());

        }
    }

}
