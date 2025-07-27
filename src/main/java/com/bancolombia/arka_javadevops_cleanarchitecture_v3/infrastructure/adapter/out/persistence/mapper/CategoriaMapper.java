package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.mapper;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Categoria;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity.CategoriaEntity;

public class CategoriaMapper {

    public Categoria toModel(CategoriaEntity categoriaEntity){
        if(categoriaEntity == null){
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(categoriaEntity.getIdCategoria());
        categoria.setNombreCategoria(categoriaEntity.getNombreCategoria());
        return categoria;
    }    

    public CategoriaEntity toEntity(Categoria categoria){
        if(categoria == null){
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setIdCategoria(categoria.getIdCategoria());
        categoriaEntity.setNombreCategoria(categoria.getNombreCategoria());
        return categoriaEntity;
    }    

}
