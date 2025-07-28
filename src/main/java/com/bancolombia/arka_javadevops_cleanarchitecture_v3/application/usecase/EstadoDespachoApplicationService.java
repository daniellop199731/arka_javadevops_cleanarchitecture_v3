package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.EstadoDespacho;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.EstadoDespachoUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.EstadoDespachoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoDespachoApplicationService implements EstadoDespachoUseCase {

    private final EstadoDespachoRepositoryPort estadoDespachoRepositoryPort;

    @Override
    public List<EstadoDespacho> getAllEstadosDespacho() {
        return estadoDespachoRepositoryPort.findAll();
    }

    @Override
    public EstadoDespacho getEstadoDespacho(int idEstadoDespacho) {
        return estadoDespachoRepositoryPort.findById(idEstadoDespacho).get();
    }

    @Override
    public EstadoDespacho createEstadoDespacho(EstadoDespacho estadoDespacho) {
        return estadoDespachoRepositoryPort.save(estadoDespacho);
    }

    @Override
    public EstadoDespacho updateEstadoDespacho(int idEstadoDespacho, EstadoDespacho estadoDespacho) {
        if(estadoDespachoRepositoryPort.existById(idEstadoDespacho)){
            estadoDespacho.setIdEstadoDespacho(idEstadoDespacho);
            return estadoDespachoRepositoryPort.save(estadoDespacho);
        }
        return new EstadoDespacho();
    }

    @Override
    public boolean deleteEstadoDespacho(int idEstadoDespacho) {
        if(estadoDespachoRepositoryPort.existById(idEstadoDespacho)){
            estadoDespachoRepositoryPort.deleteById(idEstadoDespacho);
            return true;
        }
        return false;
    }

}
