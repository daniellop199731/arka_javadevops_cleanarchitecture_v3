package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.CarritoCompraDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarritoCompraWebMapper {

    private final UsuarioWebMapper usuarioWebMapper;
    private final EstadoDespachoWebMapper estadoDespachoWebMapper;
    private final MetodoPagoWebMapper metodoPagoWebMapper;

    public CarritoCompraDto toDto(CarritoCompra carritoCompra){
        if(carritoCompra == null){
            return null;
        }

        CarritoCompraDto carritoCompraDto = new CarritoCompraDto();
        carritoCompraDto.setIdCarritoCompra(carritoCompra.getIdCarritoCompra());
        carritoCompraDto.setUsuarioCarritoCompra(usuarioWebMapper.toDto(carritoCompra.getUsuarioCarritoCompra()));
        carritoCompraDto.setEstadoDespachoCarritoCompra(estadoDespachoWebMapper.toDto(carritoCompra.getEstadoDespachoCarritoCompra()));
        carritoCompraDto.setMetodoPagoCarritoCompra(metodoPagoWebMapper.toDto(carritoCompra.getMetodoPagoCarritoCompra()));
        carritoCompraDto.setCarritoPagado(carritoCompra.getCarritoPagado());
        carritoCompraDto.setFechaCreacionCarritoCompra(carritoCompra.getFechaCreacionCarritoCompra());
        carritoCompraDto.setCantidadNotificacionesPorCarritoAbandonado(carritoCompra.getCantidadNotificacionesPorCarritoAbandonado());

        return carritoCompraDto;

    }

    public CarritoCompra toModel(CarritoCompraDto carritoCompraDto){
        if(carritoCompraDto == null){
            return null;
        }

        CarritoCompra carritoCompra = new CarritoCompra();
        carritoCompra.setIdCarritoCompra(carritoCompraDto.getIdCarritoCompra());
        carritoCompra.setUsuarioCarritoCompra(usuarioWebMapper.toModel(carritoCompraDto.getUsuarioCarritoCompra()));
        carritoCompra.setEstadoDespachoCarritoCompra(estadoDespachoWebMapper.toModel(carritoCompraDto.getEstadoDespachoCarritoCompra()));
        carritoCompra.setMetodoPagoCarritoCompra(metodoPagoWebMapper.toModel(carritoCompraDto.getMetodoPagoCarritoCompra()));
        carritoCompra.setCarritoPagado(carritoCompraDto.getCarritoPagado());
        carritoCompra.setFechaCreacionCarritoCompra(carritoCompraDto.getFechaCreacionCarritoCompra());
        carritoCompra.setCantidadNotificacionesPorCarritoAbandonado(carritoCompraDto.getCantidadNotificacionesPorCarritoAbandonado());

        return carritoCompra;

    }    

}
