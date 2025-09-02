package com.arka.cotizador.domain.port.in;

import java.util.List;

import com.arka.cotizador.domain.model.CotizacionResponse;

import reactor.core.publisher.Mono;

public interface CotizacionUseCase {

    Mono<CotizacionResponse> crearCotizacion(List<String> referenciasProductos);
}