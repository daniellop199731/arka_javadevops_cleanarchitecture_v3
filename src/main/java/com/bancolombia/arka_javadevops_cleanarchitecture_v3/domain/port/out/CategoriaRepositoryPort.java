package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Categoria;

public interface CategoriaRepositoryPort {

    List<Categoria> findAll();
    Optional<Categoria> findById(int idCategoria);
    Categoria save(Categoria categoria);
    void deleteById(int idCategoria);
    boolean existsById(int idCategoria);
}
