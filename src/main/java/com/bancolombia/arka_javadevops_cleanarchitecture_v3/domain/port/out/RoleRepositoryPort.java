package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Role;

public interface RoleRepositoryPort {

    Role save(Role role);
    List<Role> findAll();
    Optional<Role> findById(int id);
    Optional<Role> findByName(String name);
    
}
