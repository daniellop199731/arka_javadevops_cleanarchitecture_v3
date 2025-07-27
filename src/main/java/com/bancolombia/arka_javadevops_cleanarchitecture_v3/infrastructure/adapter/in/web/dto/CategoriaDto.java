package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private int idCategoria;

    @NotBlank(message = "El nombre de la categoria no puede estar vacio")
    @NotNull(message = "El nombre de la categoria es requerido")
    private String nombreCategoria;    

}
