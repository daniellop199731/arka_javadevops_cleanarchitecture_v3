package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Comment;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUseCase {

    Mono<Product> save(Product product);
    Flux<Product> getAllProducts();
    Mono<String> findInOrderBestComment();
    Flux<Comment> findCommentsByIdProduct(String id);
    
}
