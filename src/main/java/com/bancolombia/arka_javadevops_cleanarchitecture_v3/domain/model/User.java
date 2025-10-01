package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private boolean enabled;
    private List<Role> roles;
    private boolean admin;
    
}
