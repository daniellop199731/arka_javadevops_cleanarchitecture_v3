package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private int idCliente;
    private String identificacionCliente;
    private String correoElectronicoCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private String direccionDespachoCliente;
    private String contrasennaCliente;
    private String nicknameCliente;
    private Perfil perfil;
}

