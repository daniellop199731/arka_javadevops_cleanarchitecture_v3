package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.CarritoCompraEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarritoCompraMapper {

    private final UsuarioMapper usuarioMapper;
    private final EstadoDespachoMapper estadoDespachoMapper;
    private final MetodoPagoMapper metodoPagoMapper;

    public CarritoCompraEntity toEntity(CarritoCompra carritoCompra){
        if(carritoCompra == null){
            return null;
        }

        CarritoCompraEntity carritoCompraEntity = new CarritoCompraEntity();
        carritoCompraEntity.setIdCarritoCompra(carritoCompra.getIdCarritoCompra());
        carritoCompraEntity.setUsuarioCarritoCompra(usuarioMapper.toEntity(carritoCompra.getUsuarioCarritoCompra()));
        carritoCompraEntity.setEstadoDespachoCarritoCompra(estadoDespachoMapper.toEntity(carritoCompra.getEstadoDespachoCarritoCompra()));
        carritoCompraEntity.setMetodoPagoCarritoCompra(metodoPagoMapper.toEntity(carritoCompra.getMetodoPagoCarritoCompra()));
        carritoCompraEntity.setCarritoPagado(carritoCompra.getCarritoPagado());
        carritoCompraEntity.setFechaCreacionCarritoCompra(carritoCompra.getFechaCreacionCarritoCompra());
        carritoCompraEntity.setCantidadNotificacionesPorCarritoAbandonado(carritoCompra.getCantidadNotificacionesPorCarritoAbandonado());

        return carritoCompraEntity;

    }
    
    public CarritoCompra toModel(CarritoCompraEntity carritoCompraEntity){
        if(carritoCompraEntity == null){
            return null;
        }

        CarritoCompra carritoCompra = new CarritoCompra();
        carritoCompra.setIdCarritoCompra(carritoCompraEntity.getIdCarritoCompra());
        carritoCompra.setUsuarioCarritoCompra(usuarioMapper.toModel(carritoCompraEntity.getUsuarioCarritoCompra()));
        carritoCompra.setEstadoDespachoCarritoCompra(estadoDespachoMapper.toModel(carritoCompraEntity.getEstadoDespachoCarritoCompra()));
        carritoCompra.setMetodoPagoCarritoCompra(metodoPagoMapper.toModel(carritoCompraEntity.getMetodoPagoCarritoCompra()));
        carritoCompra.setCarritoPagado(carritoCompraEntity.getCarritoPagado());
        carritoCompra.setFechaCreacionCarritoCompra(carritoCompraEntity.getFechaCreacionCarritoCompra());
        carritoCompra.setCantidadNotificacionesPorCarritoAbandonado(carritoCompraEntity.getCantidadNotificacionesPorCarritoAbandonado());

        return carritoCompra;

    }    

}
