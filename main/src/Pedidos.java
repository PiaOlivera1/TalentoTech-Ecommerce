import java.util.ArrayList;

public class Pedidos {

    private int contadorProductos;
    private ArrayList<Producto> productos;

    public Pedidos(){
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public double calcularPrecioTotal(){
        if (productos.isEmpty()) {
            return 0;
        }
        double total=0;
        for (Producto producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }

    public void listarProducto(){
        for (Producto producto : productos){
            System.out.println(producto);

        }
    }

}
