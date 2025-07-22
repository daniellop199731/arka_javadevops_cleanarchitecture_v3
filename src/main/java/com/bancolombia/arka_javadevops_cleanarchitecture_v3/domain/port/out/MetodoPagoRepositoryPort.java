package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;

public interface MetodoPagoRepositoryPort {

    List<MetodoPago> findAll();
    Optional<MetodoPago> findById(int idMetodoPago);
    MetodoPago save(MetodoPago metodoPago);
    void deleteById(int idMetodoPago);
    boolean existsById(int idMetodoPago);
}

