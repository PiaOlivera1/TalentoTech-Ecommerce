package ar.ecommerce.servicio;

import ar.ecommerce.modelo.Producto;
import ar.ecommerce.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepositorio.save(producto); //el save guarda el producto y si no tiene id, ya se lo genera
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }
}
