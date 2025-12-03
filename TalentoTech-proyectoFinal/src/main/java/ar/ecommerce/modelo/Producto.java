package ar.ecommerce.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data //se generan los métodos get and set
@NoArgsConstructor // se agrega los constructores vacios automaticamente
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private double precio;
    private String descripcion;
    private String categoria;
    private Integer stock;


}
