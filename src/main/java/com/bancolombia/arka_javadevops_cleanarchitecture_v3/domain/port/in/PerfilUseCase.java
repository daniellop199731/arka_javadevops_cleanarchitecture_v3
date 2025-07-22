package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Perfil;

//Contratos de casos de usos sobre Perfil
public interface PerfilUseCase {

    List<Perfil> getAllPerfiles();
    Perfil getPerfilById(int idPerfil);
    Perfil createPerfil(Perfil perfil);
    Perfil updatePerfil(int idPerfil, Perfil perfil);
    boolean deletePerfil(int idPerfil);
    
}

