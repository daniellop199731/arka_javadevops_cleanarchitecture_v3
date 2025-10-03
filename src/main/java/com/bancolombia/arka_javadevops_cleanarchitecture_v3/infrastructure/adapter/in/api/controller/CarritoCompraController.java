package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.CarritoCompraUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.dto.CarritoCompraDto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.mapper.CarritoCompraWebMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/carritosCompra")
@RequiredArgsConstructor
public class CarritoCompraController {

    private final CarritoCompraUseCase carritoCompraUseCase;
    private final CarritoCompraWebMapper carritoCompraWebMapper;

    @GetMapping("/{idCarritoCompra}")
    public ResponseEntity<CarritoCompraDto> obtenerCarritoPorId(@PathVariable int idCarritoCompra) {        
        return ResponseEntity.ok().body(
            carritoCompraWebMapper.toDto(
                carritoCompraUseCase.obtenerCarritoPorId(idCarritoCompra)
            )
        );
    }

    @GetMapping("/carritoActual/{idCliente}")
    public ResponseEntity<CarritoCompraDto> carritoActual(@PathVariable(value = "idCliente") int idCliente) {
        return ResponseEntity.ok().body(
            carritoCompraWebMapper.toDto(
                carritoCompraUseCase.carritoActual(idCliente)
            )
        );
    }

    @GetMapping("/abandonados")
    public ResponseEntity<List<CarritoCompraDto>> carritosAbandonados() {                
        return ResponseEntity.ok().body(
            carritoCompraUseCase.carritosAbandonados().stream()
            .map(carritoCompraWebMapper::toDto)
            .toList()
        );
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<CarritoCompraDto>> carritosUsuario(@PathVariable(value = "idCliente") int idCliente) {
        return ResponseEntity.ok().body(
            carritoCompraUseCase.carritosPorUsuario(idCliente).stream()
            .map(carritoCompraWebMapper::toDto)
            .toList()
        );
    }

    @PostMapping("/crearNuevo/{idCliente}")
    public ResponseEntity<CarritoCompraDto> crearNuevo(@PathVariable(value = "idCliente") int idCliente) {                
        return ResponseEntity.ok().body(
            carritoCompraWebMapper.toDto(
                carritoCompraUseCase.crearNuevo(idCliente)
            )
        );
    }
    
    
}
