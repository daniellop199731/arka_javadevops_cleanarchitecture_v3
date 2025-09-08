package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.UsuarioUserCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.dto.UsuarioDto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.mapper.UsuarioWebMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUserCase usuarioUserCase;
    private final UsuarioWebMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioUserCase.getAllUsuarios();
        List<UsuarioDto> usuarioDtos = usuarios.stream()
            .map(mapper::toDto)
            .toList();
        return ResponseEntity.ok(usuarioDtos);
    }
    
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("idUsuario") int idUsuario) {
        Usuario usuario = usuarioUserCase.getUsuarioById(idUsuario);
        return ResponseEntity.ok(mapper.toDto(usuario));
    }

    @PostMapping("/createUsuario")
    public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioCreated = usuarioUserCase.createUsuario(mapper.toModel(usuarioDto));
        return ResponseEntity.ok(mapper.toDto(usuarioCreated));
    }

    @PutMapping("/updateUsuario/{idUsuario}")
    public ResponseEntity<UsuarioDto> putMethodName(@PathVariable("idUsuario") int idUsuario, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = mapper.toModel(usuarioDto);
        Usuario usuarioUpdated = usuarioUserCase.updateUsuario(idUsuario, usuario);
        return ResponseEntity.ok(mapper.toDto(usuarioUpdated));
    }

    @DeleteMapping("/deleteUsuario/{idUsuario}")
    public ResponseEntity<Void> deleteUsaurio(@PathVariable("idUsuario") int idUsuario){
        if(usuarioUserCase.deleteUsuario(idUsuario)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    

}

