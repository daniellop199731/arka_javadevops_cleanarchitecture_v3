package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.EstadoDespacho;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.EstadoDespachoDto;

@Component
public class EstadoDespachoWebMapper {

    public EstadoDespachoDto toDto(EstadoDespacho estadoDespacho){
        if(estadoDespacho == null){
            return null;
        }
        EstadoDespachoDto estadoDespachoDto = new EstadoDespachoDto();
        estadoDespachoDto.setIdEstadoDespacho(estadoDespacho.getIdEstadoDespacho());
        estadoDespachoDto.setNombreEstadoDespacho(estadoDespacho.getNombreEstadoDespacho());
        return estadoDespachoDto;
    }
    
    public EstadoDespacho toModel(EstadoDespachoDto estadoDespachoDto){
        if(estadoDespachoDto == null){
            return null;
        }
        EstadoDespacho estadoDespacho = new EstadoDespacho();
        estadoDespacho.setIdEstadoDespacho(estadoDespachoDto.getIdEstadoDespacho());
        estadoDespacho.setNombreEstadoDespacho(estadoDespachoDto.getNombreEstadoDespacho());
        return estadoDespacho;
    }     

}
