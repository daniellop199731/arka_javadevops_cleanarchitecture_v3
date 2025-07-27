package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Categoria;

public interface CategoriaUseCase {

    List<Categoria> getCategorias();
    Categoria getCategoriaById(int idCategoria);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(int idCategoria, Categoria categoria);
    boolean deleteCategoriaById(int idCategoria);

}
