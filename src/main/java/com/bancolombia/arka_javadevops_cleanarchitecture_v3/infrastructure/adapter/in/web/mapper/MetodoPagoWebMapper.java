package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.MetodoPagoDto;

@Component
public class MetodoPagoWebMapper {

    public MetodoPagoDto toDto(MetodoPago metodoPago) {
        if (metodoPago == null) {
            return null;
        }
        MetodoPagoDto metodoPagoDto = new MetodoPagoDto();
        metodoPagoDto.setIdMetodoPago(metodoPago.getIdMetodoPago());
        metodoPagoDto.setNombreMetodoPago(metodoPago.getNombreMetodoPago());
        return metodoPagoDto;
    }

    public MetodoPago toModel(MetodoPagoDto metodoPagoDto) {
        if (metodoPagoDto == null) {
            return null;
        }
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(metodoPagoDto.getIdMetodoPago());
        metodoPago.setNombreMetodoPago(metodoPagoDto.getNombreMetodoPago());
        return metodoPago;
    }

}

