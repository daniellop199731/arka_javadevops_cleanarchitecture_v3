package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.EstadoDespachoEntity;

@Repository
public interface EstadoDespachoJpaRepository extends JpaRepository<EstadoDespachoEntity, Integer> {

}
