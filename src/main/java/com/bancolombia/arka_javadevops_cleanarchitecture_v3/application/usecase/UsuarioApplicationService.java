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
        Optional<Usuario> usuarioFindedById = usuarioRepositoryPort.findById(idUsuario);
        
        if(!usuarioFindedById.isPresent()){
            return new Usuario();
        }

        if(this.canUpdateUsuario(usuario.getIdentificacionUsuario(), idUsuario)){
            usuario.setIdUsuario(idUsuario);
            return usuarioRepositoryPort.save(usuario);
        }
        
        return usuarioFindedById.get();
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

    @Override
    public boolean canUpdateUsuario(String identificacionUsuario, int idUsuario) {
        /**
         * El usuario se puede actualizar si:
         * 1. La identificacion nueva no existe en la base de datos
         * 2. Si la identificacion nueva existe, debe ser del mismo usuario
         *    (es decir, el idUsuario debe coincidir con el id del usuario encontrado
         */

        Optional<Usuario> usuarioFinded = usuarioRepositoryPort.findByIdentificacion(identificacionUsuario);
        if(usuarioFinded.isPresent()){
            //Indica que la identificacion ya existe
            //Se debe validar si existe para el mismo id de usuario
            if(usuarioFinded.get().getIdUsuario() == idUsuario){
                return true;
            }
            return false;
        }
        return true;
    }
    
}

