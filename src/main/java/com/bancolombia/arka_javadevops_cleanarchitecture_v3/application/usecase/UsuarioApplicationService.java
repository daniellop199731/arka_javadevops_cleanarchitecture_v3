package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.UsuarioUserCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioUserCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepositoryPort.findAll();
    }

    @Override
    public Usuario getUsuarioById(int idUsuario) {
        Optional<Usuario> usuarioFinded = usuarioRepositoryPort.findById(idUsuario);
        if(usuarioFinded.isPresent()){
            return usuarioFinded.get();
        }
        return new Usuario();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioFinded = this.getUsuarioByIdentificacion(usuario.getIdentificacionUsuario());
        if(usuarioFinded.getIdUsuario() == 0 ){            
            return usuarioRepositoryPort.save(usuario);
        }
        return usuarioFinded;
    }

    @Override
    public Usuario updateUsuario(int idUsuario, Usuario usuario) {   
        Usuario usuarioFindedByIdentificacion = this.getUsuarioByIdentificacion(usuario.getIdentificacionUsuario());
        boolean existsById = usuarioRepositoryPort.existsById(idUsuario);
        if(usuarioFindedByIdentificacion.getIdUsuario() == 0 && existsById){
            usuario.setIdUsuario(idUsuario);
            return usuarioRepositoryPort.save(usuario);
        }

        if(!existsById){
            throw new RuntimeException("Usuario not found with id: " + idUsuario);
        }
        
        return usuarioFindedByIdentificacion;
    }

    @Override
    public boolean deleteUsuario(int idUsuario) {
        if(usuarioRepositoryPort.existsById(idUsuario)){
            usuarioRepositoryPort.deleteById(idUsuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario getUsuarioByIdentificacion(String identificacionUsuario) {
        Optional<Usuario> usuarioFinded = usuarioRepositoryPort.findByIdentificacion(identificacionUsuario);
        if(usuarioFinded.isPresent()){
            return usuarioFinded.get();
        }
        return new Usuario();
    }
    
}

