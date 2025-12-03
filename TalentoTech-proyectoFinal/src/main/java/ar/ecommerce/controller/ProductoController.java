package ar.ecommerce.controller;

import ar.ecommerce.modelo.Producto;
import ar.ecommerce.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/products")
    public Producto createProduct(@RequestBody Producto producto) {
        return productoServicio.agregarProducto(producto);
    }

}
