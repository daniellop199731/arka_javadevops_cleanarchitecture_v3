package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

public interface UsuarioUserCase {

    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int idUsuario);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(int idUsuario, Usuario usuario);
    boolean deleteUsuario(int idUsuario);
    Usuario getUsuarioByIdentificacion(String identificacionUsuario);
    boolean canUpdateUsuario(String identificacionUsuario, int idUsuario);
    
}

