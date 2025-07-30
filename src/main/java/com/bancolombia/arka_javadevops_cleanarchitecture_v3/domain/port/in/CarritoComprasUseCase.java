package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;

public interface CarritoComprasUseCase {

    List<CarritoCompra> getAllCarritoCompra();
    CarritoCompra getCarritoCompraById(int idCarritoCompra);
    CarritoCompra getCurrentCarritoCompra(int idUsuario);
    CarritoCompra createCarritoCompra(int idUsuario);
    CarritoCompra updateCarritoCompras(int idCarritoCompra, CarritoCompra carritoCompra);
    boolean deleteCarritoCompra(int idCarritoCompra);

}
