package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {

    private Integer idCategoria;
    private String nombreCategoria;

}
