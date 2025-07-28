package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Producto;

public interface ProductoRepositoryPort {

    List<Producto> findAll();
    Optional<Producto> findById(int idProducto);
    Producto save(Producto producto);
    void deleteById(int idProducto);
    boolean existById(int idProducto);

}
