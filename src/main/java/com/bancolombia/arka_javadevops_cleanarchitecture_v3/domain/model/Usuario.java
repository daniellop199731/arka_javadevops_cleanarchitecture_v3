package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private int idUsuario;
    private String identificacionUsuario;
    private String correoElectronicoUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private String direccionDespachoUsuario;
    private String contrasennaUsuario;
    private String nicknameUsuario;
    private Perfil perfil;
}

