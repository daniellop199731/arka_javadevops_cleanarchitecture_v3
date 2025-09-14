package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import org.springframework.stereotype.Service;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Comment;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Product;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.ProductUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.ProductRepositoryPort;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductApplicationService implements ProductUseCase{

    private final ProductRepositoryPort repositoryPort;

    @Override
    public Mono<Product> save(Product product) {
        return repositoryPort.save(product);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return repositoryPort.findAll();
    }

    @Override
    public Mono<String> findInOrderBestComment() {
        return repositoryPort.findInOrderBestComment();
    }

    @Override
    public Flux<Comment> findCommentsByIdProduct(String id) {
        return repositoryPort.findCommentsByIdProduct(id);
    }
    
}
