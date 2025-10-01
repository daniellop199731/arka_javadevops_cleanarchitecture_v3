package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Role;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.dto.RoleDto;

@Component
public class RoleWebMapper {

    public Role toModel(RoleDto roleDto){
        if(roleDto == null){
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }

    public RoleDto toDto(Role role){
        if(role == null){
            return null;
        }
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

}
