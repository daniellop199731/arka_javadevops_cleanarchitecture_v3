package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.EstadoDespacho;

public interface EstadoDespachoUseCase {

    List<EstadoDespacho> getAllEstadosDespacho();
    EstadoDespacho getEstadoDespacho(int idEstadoDespacho);
    EstadoDespacho createEstadoDespacho(EstadoDespacho estadoDespacho);
    EstadoDespacho updateEstadoDespacho(int idEstadoDespacho, EstadoDespacho estadoDespacho);
    boolean deleteEstadoDespacho(int idEstadoDespacho);
}
