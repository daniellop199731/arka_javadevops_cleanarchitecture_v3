package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

public interface UsuarioRepositoryPort {

    List<Usuario> findAll();
    Optional<Usuario> findById(int idUsuario);
    Usuario save(Usuario usuario);
    void deleteById(int idUsuario);
    boolean existsById(int idUsuario);
    Optional<Usuario> findByIdentificacion(String identificacionUsuario);
}

