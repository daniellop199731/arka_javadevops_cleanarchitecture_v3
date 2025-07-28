package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Producto;

public interface ProductoUseCase {

    List<Producto> getAllProductos();
    Producto getProductoById(int idProducto);
    Producto createProducto(Producto producto);
    Producto updateProducto(int idProducto, Producto producto);
    boolean deleteProducto(int idProducto);
    Producto increaseStock(int idProducto, int stock);
    Producto decreaseStock(int idProducto, int stock);
}
