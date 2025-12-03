package ar.ecommerce.servicio;

import ar.ecommerce.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    List<Producto> listarProductos();

    Producto buscarProductoPorId(Integer id);

    Producto agregarProducto(Producto producto);

    Producto modificarProducto(Producto producto);

    void eliminarProducto(Producto producto);
}
