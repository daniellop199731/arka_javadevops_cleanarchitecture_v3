package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Producto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.ProductoDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoUseCase {

    List<Producto> getAllProductos();
    Producto getProductoById(int idProducto);
    Producto createProducto(Producto producto);
    Producto updateProducto(int idProducto, Producto producto);
    boolean deleteProducto(int idProducto);
    Producto increaseStock(int idProducto, int stock);
    Producto decreaseStock(int idProducto, int stock);

    Flux<Producto> reactiveGetAllProductos();
    Mono<ProductoDto> getProductoByIdReactive(int idProducto);
    Mono<Double> getPrice(int idProducto);
}
