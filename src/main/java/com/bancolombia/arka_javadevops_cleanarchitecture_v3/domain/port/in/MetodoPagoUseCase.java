package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;

public interface MetodoPagoUseCase {

    List<MetodoPago> getMetodosPago();
    MetodoPago getMetodoPagoById(int idMetodoPago);
    MetodoPago createMetodoPago(MetodoPago metodoPago);
    MetodoPago updateMetodoPago(int idMetodoPago, MetodoPago metodoPago);
    MetodoPago deleteMetodoPagoById(int idMetodoPago);

}

