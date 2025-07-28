package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.EstadoDespacho;

public interface EstadoDespachoRepositoryPort {

    List<EstadoDespacho> findAll();
    Optional<EstadoDespacho> findById();
    EstadoDespacho save(EstadoDespacho estadoDespacho);
    void deleteById(int idEstadoDespacho);
    boolean existById(int idEstadoDespacho);
}
