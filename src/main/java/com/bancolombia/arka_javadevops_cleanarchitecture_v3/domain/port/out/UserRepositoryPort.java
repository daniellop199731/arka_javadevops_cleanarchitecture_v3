package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.User;

public interface UserRepositoryPort {

    User save(User user);
    List<User> findAll();
    Optional<User> findById(int id);
    boolean existByUserName(String userNamer);
    Optional<User> findByUsername(String username);
}
