package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.MetodoPagoUsuarioRepositoryPort;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.MetodoPagoUsuarioEntity;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper.MetodoPagoUsuarioMapper;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper.UsuarioMapper;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository.MetodoPagoUsuarioJR;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MetodoPagoUsuarioPersistenceAdapter implements MetodoPagoUsuarioRepositoryPort {

    private final MetodoPagoUsuarioJR repository;
    private final MetodoPagoUsuarioMapper metodoPagoUsuarioMapper;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<MetodoPagoUsuario> findByUsuarioMetodoPago(Usuario usuario) {
        List<MetodoPagoUsuarioEntity> metodoPagoUsuarioEntities = repository.findByUsuarioMetodoPago(usuarioMapper.toEntity(usuario));
        return metodoPagoUsuarioEntities.stream()
                .map(metodoPagoUsuarioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public MetodoPagoUsuario save(MetodoPagoUsuario metodoPagoUsuario) {
        MetodoPagoUsuarioEntity metodoPagoUsuarioEntity = metodoPagoUsuarioMapper.toEntity(metodoPagoUsuario);
        if(metodoPagoUsuario.getId() == 0){
            metodoPagoUsuarioEntity.setId(null);
        }
        return metodoPagoUsuarioMapper.toModel(repository.save(metodoPagoUsuarioEntity));
    }

    @Override
    public MetodoPagoUsuario update(int id, MetodoPagoUsuario metodoPagoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
