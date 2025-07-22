package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metodosPagoUsuario")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagoUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuarioMetodoPago")
    private UsuarioEntity usuarioMetodoPago;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MetodoPagoEntity metodoPago;

    private double valorCuentaMetodoPago;

}
