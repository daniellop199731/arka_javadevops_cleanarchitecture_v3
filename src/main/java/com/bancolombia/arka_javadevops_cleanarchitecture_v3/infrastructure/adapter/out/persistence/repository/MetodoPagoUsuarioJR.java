package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.MetodoPagoUsuarioEntity;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.UsuarioEntity;

//MetodoPagoUsuarioJpaRepository: se guarda el archivo como MetodoPagoUsuarioJR
//porque fork se puso caprichoso con los nombres largos de los archivos
public interface MetodoPagoUsuarioJR extends JpaRepository<MetodoPagoUsuarioEntity, Integer> {

    List<MetodoPagoUsuarioEntity> findByUsuarioMetodoPago(UsuarioEntity usuario);

    @Query(nativeQuery = true, value = "select * from metodosPagoUsuario M where idUsuarioMetodoPago = ?1 and idMetodoPago = ?2")
    Optional<MetodoPagoUsuarioEntity> findByUsuarioAndMetodoPago(int idUsuarioMetodoPago, int idMetodoPago);
}
