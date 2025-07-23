package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.utils.ResponseObject;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;

public interface MetodoPagoUsuarioUseCase {

    List<MetodoPagoUsuario> getMetodosPagoByIdUsuario(int idUsuario);
    ResponseObject<MetodoPagoUsuario> createMetodoPagoUsuario(int idMetodoPago, int idUsuario);

    /**
     * Gestiona creacion y actualizacion
     * Si existe la combinacion de usuario y metodo de pago, solo actualiza el valor de la cuenta
     * Si no existe la combinacion de usuario y metodo de pago, se crea un nuevo registro
     * @param idUsuario         id del usuario al que se le asignara el metodo de pago
     * @param idMetodoCuenta    id del metodo de pago a asignar
     * @param valorCuenta       valor monetario a recargar en el metodo de pago
     * @return                  objeto modelo de metodo pago con los datos persistidos
     */
    ResponseObject<MetodoPagoUsuario> manageMetodoPagoUsuario(int idUsuario, int idMetodoCuenta, double valorCuenta);
    boolean deleteByIdUsuarioAndMetodoPago(int idUsuario,int idMetodoPago);

}
