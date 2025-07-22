package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.MetodoPagoUsuarioEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MetodoPagoUsuarioMapper {

    private final UsuarioMapper usuarioMapper;
    private final MetodoPagoMapper metodoPagoMapper;

    public MetodoPagoUsuario toModel(MetodoPagoUsuarioEntity metodoPagoUsuarioEntity){
        if(metodoPagoUsuarioEntity == null){
            return null;
        }

        MetodoPagoUsuario metodoPagoUsuario = new MetodoPagoUsuario();
        metodoPagoUsuario.setId(metodoPagoUsuarioEntity.getId());
        metodoPagoUsuario.setUsuarioMetodoPago(usuarioMapper.toModel(metodoPagoUsuarioEntity.getUsuarioMetodoPago()));
        metodoPagoUsuario.setMetodoPago(metodoPagoMapper.toModel(metodoPagoUsuarioEntity.getMetodoPago()));
        metodoPagoUsuario.setValorCuentaMetodoPago(metodoPagoUsuarioEntity.getValorCuentaMetodoPago());
        return metodoPagoUsuario;
    }

    public MetodoPagoUsuarioEntity toEntity(MetodoPagoUsuario metodoPagoUsuario){
        if(metodoPagoUsuario == null){
            return null;
        }

        MetodoPagoUsuarioEntity metodoPagoUsuarioEntity = new MetodoPagoUsuarioEntity();
        metodoPagoUsuarioEntity.setId(metodoPagoUsuario.getId());
        metodoPagoUsuarioEntity.setUsuarioMetodoPago(usuarioMapper.toEntity(metodoPagoUsuario.getUsuarioMetodoPago()));
        metodoPagoUsuarioEntity.setMetodoPago(metodoPagoMapper.toEntity(metodoPagoUsuario.getMetodoPago()));
        metodoPagoUsuarioEntity.setValorCuentaMetodoPago(metodoPagoUsuario.getValorCuentaMetodoPago());
        return metodoPagoUsuarioEntity;
    }
}
