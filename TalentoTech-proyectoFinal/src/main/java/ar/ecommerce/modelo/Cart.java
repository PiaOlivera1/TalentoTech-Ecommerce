package ar.ecommerce.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    // Agregar producto al carrito
    public void add(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) return;

        for (CartItem item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }

        items.add(new CartItem(producto, cantidad));
    }


    // Eliminar producto del carrito
    public void remove(Integer productoId) {
        if (productoId == null) return;

        items.removeIf(item -> item.getProducto().getId().equals(productoId));
    }

    // Cambiar la cantidad
    public void update(Integer productoId, int cantidad) {
        if (productoId == null || cantidad <= 0) return;

        for (CartItem item : items) {
            if (item.getProducto().getId().equals(productoId)) {
                item.setCantidad(cantidad);
                return;
            }
        }
    }

    // Obtener ítems
    public List<CartItem> getItems() {
        return items;
    }

    // Total del carrito
    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            double precio = item.getProducto().getPrecio();
            int cantidad = item.getCantidad();

            total += precio * cantidad;
        }

        return total;
    }

}
