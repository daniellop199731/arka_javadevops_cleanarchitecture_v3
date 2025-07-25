package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagoUsuarioDto {

    private int id;

    @NotNull(message = "El usuario del metodo de pago no puede ser nulo")
    private Usuario usuarioMetodoPago;

    @NotNull(message = "El metodo de pago no puede ser nulo")
    private MetodoPago metodoPago;

    @NotNull(message = "El valor de la cuenta del metodo de pago no puede ser nulo")
    @Positive(message = "El valor de la cuenta del metodo de pago debe ser positivo")
    private double valorCuentaMetodoPago;

}
