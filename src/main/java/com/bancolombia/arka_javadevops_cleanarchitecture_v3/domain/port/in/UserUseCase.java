package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.User;

public interface UserUseCase {

    User createUser(User user);
    List<User> getAllUsers();
    boolean existsByUserName(String userName);                                                                                                                                  
    
}
