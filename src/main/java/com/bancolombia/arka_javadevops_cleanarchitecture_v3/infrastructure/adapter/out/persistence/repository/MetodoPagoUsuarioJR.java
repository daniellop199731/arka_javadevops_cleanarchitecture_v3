package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.MetodoPagoUsuarioEntity;

//MetodoPagoUsuarioJpaRepository: se guarda el archivo como MetodoPagoUsuarioJR
//porque fork se puso caprichoso con los nombres largos de los archivos
public interface MetodoPagoUsuarioJR extends JpaRepository<MetodoPagoUsuarioEntity, Integer> {

}
