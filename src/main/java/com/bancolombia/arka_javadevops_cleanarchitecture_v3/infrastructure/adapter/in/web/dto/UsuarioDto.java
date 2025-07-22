package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private int idUsuario;

    @NotNull(message = "Debe proporcionar una ideantificacion")
    @NotBlank(message = "Debe proporcionar una ideantificacion")
    @Size(min = 9, max = 15, message = "Debe proporcionar una ideantificacion valida")
    private String identificacionUsuario;

    @NotNull(message = "Debe proporcionar un correo electronico")
    @NotBlank(message = "Debe proporcionar un correo electronico")
    @Email(message = "Debe proporcionar una direccion de correo con una estructura valida")    
    private String correoElectronicoUsuario;

    @NotNull(message = "Debe proporcionar los nombres")
    @NotBlank(message = "Debe proporcionar los nombres")
    @Size(min = 3, max = 45)
    private String nombresUsuario;

    @NotNull(message = "Debe proporcionar los apellidos")   
    @NotBlank(message = "Debe proporcionar los apellidos")   
    @Size(min = 5, max = 45)
    private String apellidosUsuario;

    private String direccionDespachoUsuario;
    private String nicknameUsuario;
    private PerfilDto perfil;    

}

