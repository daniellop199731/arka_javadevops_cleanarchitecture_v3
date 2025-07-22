package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.utils.ResponseObject;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;

public interface MetodoPagoUsuarioUseCase {

    List<MetodoPago> getMetodosPagoByIdUsuario(int idUsuario);
    ResponseObject<MetodoPagoUsuario> createMetodoPagoUsuario(int idMetodoPago, int idUsuario);
    ResponseObject<MetodoPagoUsuario> updateValorCuentaById(int id, double valorCuenta);
    ResponseObject<MetodoPagoUsuario> updateValorCuentaByIdUsuarioIdMetodoPago(int idUsuario, int idMetodoCuenta, double valorCuenta);
    ResponseObject<MetodoPagoUsuario> deleteMetodoPagoUsuario(int id);
    ResponseObject<MetodoPagoUsuario> deleteValorCuentaByIdUsuarioIdMetodoPago(int idUsuario, int idMetodoCuenta);

}
