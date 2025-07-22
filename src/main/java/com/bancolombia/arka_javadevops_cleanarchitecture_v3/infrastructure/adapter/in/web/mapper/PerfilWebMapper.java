package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Perfil;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.PerfilDto;

@Component
public class PerfilWebMapper {

    public PerfilDto toDto(Perfil perfil) {
        if (perfil == null) {
            return null;
        }
        PerfilDto perfilDto = new PerfilDto();
        perfilDto.setIdPerfil(perfil.getIdPerfil());
        perfilDto.setNombrePerfil(perfil.getNombrePerfil());
        return perfilDto;
    }

    public Perfil toModel(PerfilDto perfilDto) {
        if (perfilDto == null) {
            return null;
        }
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(perfilDto.getIdPerfil());
        perfil.setNombrePerfil(perfilDto.getNombrePerfil());
        return perfil;
    }

}
