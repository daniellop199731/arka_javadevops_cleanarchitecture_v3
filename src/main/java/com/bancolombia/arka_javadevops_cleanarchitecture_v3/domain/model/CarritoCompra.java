package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompra {

    private int idCarritoCompra;
    private Usuario usuarioCarritoCompra;
    private EstadoDespacho estadoDespachoCarritoCompra;
    private MetodoPago metodoPagoCarritoCompra;
    private int carritoPagado;
    private Date fechaCreacionCarritoCompra;
    private int cantidadNotificacionesPorCarritoAbandonado;

}
