package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private int idProducto;
    private String referenciaProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioProducto;
    private int stockProducto;
    private int stockMinimoProducto;
    private Proveedor proveedorProducto;
    private int unidadesSolicitarProducto;
    private Categoria categoriaProducto;
}
