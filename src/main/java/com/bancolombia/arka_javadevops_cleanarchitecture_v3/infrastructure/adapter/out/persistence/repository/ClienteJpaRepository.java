package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.ClienteEntity;

public interface ClienteJpaRepository extends CrudRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByIdentificacionCliente(String identificacionCliente);

}

