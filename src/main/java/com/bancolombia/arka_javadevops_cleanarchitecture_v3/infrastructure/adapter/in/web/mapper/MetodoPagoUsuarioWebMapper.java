package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.MetodoPagoUsuarioDto;

@Component
public class MetodoPagoUsuarioWebMapper {

    public MetodoPagoUsuarioDto toDto(MetodoPagoUsuario metodoPagoUsuario) {
        if (metodoPagoUsuario == null) {
            return null;
        }
        MetodoPagoUsuarioDto metodoPagoUsuarioDto = new MetodoPagoUsuarioDto();
        metodoPagoUsuarioDto.setId(metodoPagoUsuario.getId());
        metodoPagoUsuarioDto.setUsuarioMetodoPago(metodoPagoUsuario.getUsuarioMetodoPago());
        metodoPagoUsuarioDto.setMetodoPago(metodoPagoUsuario.getMetodoPago());
        metodoPagoUsuarioDto.setValorCuentaMetodoPago(metodoPagoUsuario.getValorCuentaMetodoPago());
        return metodoPagoUsuarioDto;
    }

    public MetodoPagoUsuario toModel(MetodoPagoUsuarioDto metodoPagoUsuarioDto){
        if (metodoPagoUsuarioDto == null) {
            return null;
        }
        MetodoPagoUsuario metodoPagoUsuario = new MetodoPagoUsuario();
        metodoPagoUsuario.setId(metodoPagoUsuarioDto.getId());
        metodoPagoUsuario.setUsuarioMetodoPago(metodoPagoUsuarioDto.getUsuarioMetodoPago());
        metodoPagoUsuario.setMetodoPago(metodoPagoUsuarioDto.getMetodoPago());
        metodoPagoUsuario.setValorCuentaMetodoPago(metodoPagoUsuarioDto.getValorCuentaMetodoPago());
        return metodoPagoUsuario;        
    }

}
