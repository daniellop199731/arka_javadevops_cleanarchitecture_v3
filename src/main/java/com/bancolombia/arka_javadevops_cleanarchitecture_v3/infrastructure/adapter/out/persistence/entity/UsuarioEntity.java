package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String identificacionUsuario;
    private String correoElectronicoUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private String direccionDespachoUsuario;
    private String contrasennaUsuario;
    private String nicknameUsuario;

    @ManyToOne
    @JoinColumn(name = "idPerfilUsuario")
    private PerfilEntity perfil;    

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioMetodoPago")
    private List<MetodoPagoUsuarioEntity> metodsPagoUsuario;
}

