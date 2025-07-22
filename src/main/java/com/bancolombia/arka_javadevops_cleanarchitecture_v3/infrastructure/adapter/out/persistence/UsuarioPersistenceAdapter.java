package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.UsuarioRepositoryPort;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper.UsuarioMapper;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository.UsuarioJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> usuariosEntities = (List<UsuarioEntity>) repository.findAll();
        return usuariosEntities.stream()
            .map(mapper::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findById(int idUsuario) {
        Optional<UsuarioEntity> usuarioEntity = repository.findById(idUsuario);
        return usuarioEntity.map(mapper::toModel);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        if(usuarioEntity.getIdUsuario() == 0){
            usuarioEntity.setIdUsuario(null);
        }
        UsuarioEntity usuarioEntitySaved = repository.save(usuarioEntity);
        return mapper.toModel(usuarioEntitySaved);
    }

    @Override
    public void deleteById(int idUsuario) {
        repository.deleteById(idUsuario);
        
    }

    @Override
    public boolean existsById(int idUsuario) {
        Optional<UsuarioEntity> usuarioFinded = repository.findById(idUsuario);
        if(usuarioFinded.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Usuario> findByIdentificacion(String identificacionUsuario) {
        Optional<UsuarioEntity> usuarioEntity = repository.findByIdentificacionUsuario(identificacionUsuario);
        return usuarioEntity.map(mapper::toModel);
    }

}

