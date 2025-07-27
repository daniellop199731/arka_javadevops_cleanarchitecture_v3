package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    
    private String identificacionProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String correoElectronicoProveedor;

}
