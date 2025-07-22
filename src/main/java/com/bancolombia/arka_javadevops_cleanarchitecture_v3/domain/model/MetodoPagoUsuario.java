package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagoUsuario {

    private int id;
    private Usuario usuarioMetodoPago;
    private MetodoPago metodoPago;
    private double valorCuentaMetodoPago;

}
