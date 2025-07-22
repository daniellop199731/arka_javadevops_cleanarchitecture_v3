package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.PerfilEntity;

// Interfaz que extiende JpaRepository para manejar operaciones CRUD de PerfilEntity
// JpaRepository proporciona métodos para realizar operaciones de base de datos sin necesidad de implementarlos manualmente
public interface PerfilJpaRepository extends JpaRepository<PerfilEntity, Integer> {

}

