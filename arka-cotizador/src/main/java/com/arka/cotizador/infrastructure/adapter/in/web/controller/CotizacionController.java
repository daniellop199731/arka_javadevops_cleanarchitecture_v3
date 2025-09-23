package com.arka.cotizador.infrastructure.adapter.in.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.arka.cotizador.domain.model.CotizacionResponse;
import com.arka.cotizador.domain.port.in.CotizacionUseCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/cotizacion")
@CrossOrigin(origins = "*", maxAge = 3600)

@RequiredArgsConstructor
public class CotizacionController {

        private static final Logger logger = LoggerFactory.getLogger(CotizacionController.class);

    private final CotizacionUseCase service;

    @GetMapping("/testCotizacion")
    //Indica que roles pueden acceder a este endpoint
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'GESTOR', 'OPERADOR', 'USUARIO')")
    public String testCotizacion(
        @RequestHeader("X-User-Id") String userId,
        @RequestHeader("X-User-Name") String username
    ) {

        logger.info("Usuario {} (ID: {}) solicita cálculo de envío: {}", username, userId);        

        return "Controlador para gestion de cotizaciones";
    }

    @GetMapping("/totalPriceProducts")
    public Mono<Double> totalPriceProducts(@RequestBody List<Integer> idsProductos) {
        return service.totalPriceProducts(idsProductos);
    }

    @GetMapping("/nuevaCotizacion")
    public Mono<CotizacionResponse> nuevaCotizacion(@RequestBody List<Integer> idsProductos) {
        return service.crearCotizacion(idsProductos);
    }    
    
    
}
