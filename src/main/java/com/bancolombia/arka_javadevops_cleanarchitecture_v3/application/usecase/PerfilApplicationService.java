package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Perfil;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.PerfilUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.PerfilRepositoryPort;

import lombok.RequiredArgsConstructor;

//Definicion del contrato de casos de uso para el Perfil
// Implementa el puerto de entrada definido en PerfilUseCase
@Service
@RequiredArgsConstructor
public class PerfilApplicationService implements PerfilUseCase {

    private final PerfilRepositoryPort perfilRepository;

    @Override
    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil getPerfilById(int idPerfil) {
        return perfilRepository.findById(idPerfil).get();
    }

    @Override
    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil updatePerfil(int idPerfil, Perfil perfil) {
        if(perfilRepository.existsById(idPerfil)){
            perfil.setIdPerfil(idPerfil); // Aseguramos que el ID sea el correcto
            return perfilRepository.save(perfil);
        } else {
            throw new RuntimeException("Perfil not found with id: " + idPerfil);
        }   
    }

    @Override
    public boolean deletePerfil(int idPerfil) {
        if(perfilRepository.existsById(idPerfil)){
            perfilRepository.deleteById(idPerfil);
            return true;
        } else {
            return false;
        }
    }

}

