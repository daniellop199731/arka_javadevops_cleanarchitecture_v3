package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

public interface CarritoCompraReposirotyPort {

    List<CarritoCompra> findAll();
    Optional<CarritoCompra> findById(int idCarritoCompra);
    Optional<CarritoCompra> findCurrent(Usuario usuario);
    CarritoCompra save(CarritoCompra carritoCompra);
    void deleteById(int idCarritoCompra);
    boolean existById(int idCarritoCompra);
}
