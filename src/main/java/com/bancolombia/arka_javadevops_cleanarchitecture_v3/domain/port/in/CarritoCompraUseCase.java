package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.Date;
import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;

public interface CarritoCompraUseCase {
    
    CarritoCompra crearNuevo(int idCliente);
    CarritoCompra obtenerCarritoPorId(int idCarritoCompra);
    List<CarritoCompra> carritosPorUsuario(int idCliente);
    CarritoCompra carritoActual(int idCliente);
    List<CarritoCompra> carritosAbandonados();
    List<CarritoCompra> carritoComprasPorFechas(Date startDate, Date finishDate);

}
