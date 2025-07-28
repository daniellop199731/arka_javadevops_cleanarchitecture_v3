package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Producto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.ProductoUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.ProductoDto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper.ProductoWebMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoUseCase productoUseCase;
    private final ProductoWebMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<Producto> productos = productoUseCase.getAllProductos();
        List<ProductoDto> productosDto = productos.stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(productosDto);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable("idProducto") int idProducto) {
        return ResponseEntity.ok( mapper.toDto(productoUseCase.getProductoById(idProducto)));
    }    

    @PostMapping("/createProducto")
    public ResponseEntity<ProductoDto> createProducto(@Valid @RequestBody ProductoDto productoDto) {
        Producto producto = mapper.toModel(productoDto);
        return ResponseEntity.ok(mapper.toDto(productoUseCase.createProducto(producto)));
    }

    @PutMapping("/updateProducto/{idProducto}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable("idProducto") int idProducto, @Valid @RequestBody ProductoDto productoDto) {
        Producto producto = mapper.toModel(productoDto);
        return ResponseEntity.ok(mapper.toDto(productoUseCase.updateProducto(idProducto, producto)));
    }    

    @DeleteMapping("/deleteProducto/{idProducto}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("idProducto") int idProducto){
        if(productoUseCase.deleteProducto(idProducto)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
