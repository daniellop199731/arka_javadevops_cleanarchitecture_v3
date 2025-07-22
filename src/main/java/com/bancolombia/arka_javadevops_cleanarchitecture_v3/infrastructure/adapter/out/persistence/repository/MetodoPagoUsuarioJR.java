package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.MetodoPagoUsuarioEntity;

public interface MetodoPagoUsuarioJR extends JpaRepository<MetodoPagoUsuarioEntity, Integer> {

}
