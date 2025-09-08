package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.mapper;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.dto.UsuarioDto;

@Component
public class UsuarioWebMapper {

    public UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        usuarioDto.setIdentificacionUsuario(usuario.getIdentificacionUsuario());
        usuarioDto.setCorreoElectronicoUsuario(usuario.getCorreoElectronicoUsuario());
        usuarioDto.setNombresUsuario(usuario.getNombresUsuario());
        usuarioDto.setApellidosUsuario(usuario.getApellidosUsuario());
        usuarioDto.setDireccionDespachoUsuario(usuario.getDireccionDespachoUsuario());
        usuarioDto.setNicknameUsuario(usuario.getNicknameUsuario());
        usuarioDto.setPerfil(new PerfilWebMapper().toDto(usuario.getPerfil()));
        return usuarioDto;
    }

    public Usuario toModel(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDto.getIdUsuario());
        usuario.setIdentificacionUsuario(usuarioDto.getIdentificacionUsuario());
        usuario.setCorreoElectronicoUsuario(usuarioDto.getCorreoElectronicoUsuario());
        usuario.setNombresUsuario(usuarioDto.getNombresUsuario());
        usuario.setApellidosUsuario(usuarioDto.getApellidosUsuario());
        usuario.setDireccionDespachoUsuario(usuarioDto.getDireccionDespachoUsuario());
        usuario.setNicknameUsuario(usuarioDto.getNicknameUsuario());
        usuario.setPerfil(new PerfilWebMapper().toModel(usuarioDto.getPerfil()));
        return usuario;
    }

}

