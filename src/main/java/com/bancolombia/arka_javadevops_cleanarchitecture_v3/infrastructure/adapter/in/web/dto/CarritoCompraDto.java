package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompraDto {

    private int idCarritoCompra;

    @NotNull(message = "Se debe asociar un usuario existente al carrito de compras")
    private UsuarioDto usuarioCarritoCompra;

    private EstadoDespachoDto estadoDespachoCarritoCompra;
    private MetodoPagoDto metodoPagoCarritoCompra;
    private int carritoPagado;
    private Date fechaCreacionCarritoCompra;
    private int cantidadNotificacionesPorCarritoAbandonado;    

}
