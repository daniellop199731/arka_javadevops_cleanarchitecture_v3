package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.UserEntity;

public interface UserJpaRepository extends CrudRepository<UserEntity, Integer> {
    
    boolean existsByUsername(String userName);

    Optional<UserEntity> findByUsername(String username);
}
