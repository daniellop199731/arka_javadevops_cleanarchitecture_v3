package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompraProducto {

    private int id;
    private CarritoCompra carritoCompra;
    private Producto productoCarritoCompra;
    private int unidadesProducto; 
    
    public CarritoCompraProducto(int idCarrito, int idProducto, int unidadesProducto){
        CarritoCompra carrito = new CarritoCompra();
        carritoCompra.setIdCarritoCompra(idCarrito);
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        this.carritoCompra = carrito;
        this.productoCarritoCompra = producto;
        this.unidadesProducto = unidadesProducto;
        
    }
    
}
