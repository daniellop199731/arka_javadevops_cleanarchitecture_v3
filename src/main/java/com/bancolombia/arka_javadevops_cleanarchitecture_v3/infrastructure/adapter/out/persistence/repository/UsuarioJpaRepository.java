package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.UsuarioEntity;

public interface UsuarioJpaRepository extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByIdentificacionUsuario(String identificacionUsuario);

}

