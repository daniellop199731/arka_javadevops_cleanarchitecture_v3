package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.ProveedorEntity;

public interface ProveedorJpaRepository extends JpaRepository<ProveedorEntity, Integer> {

}
