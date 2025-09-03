package com.arka.cotizador.infrastructure.adapter.in.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.arka.cotizador.domain.port.in.CotizacionUseCase;


@RestController
@RequestMapping("/cotizacion")
@RequiredArgsConstructor
public class CotizacionController {

    private final CotizacionUseCase service;

    @GetMapping("/testCotizacion")
    public String testCotizacion() {
        return "Controlador para gestion de cotizaciones";
    }

    @GetMapping("/nueva")
    public String nuevaCotizacion(@RequestBody List<String> referenciasProductos) {
        service.crearCotizacion(referenciasProductos);
        return new String("Cotizacion creada");
    }
    
    
}
