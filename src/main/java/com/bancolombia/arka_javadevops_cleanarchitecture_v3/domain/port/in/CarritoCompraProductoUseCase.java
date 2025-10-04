package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompraProducto;

public interface CarritoCompraProductoUseCase {

    List<CarritoCompraProducto> obtenerProductosCarrito(int idCarrito);
    CarritoCompraProducto agregarRelacionCarritoProducto(int idCarrito, int idProducto, int unidades);
    void eliminarProductosCarrito(int idCarrito);
    
}
