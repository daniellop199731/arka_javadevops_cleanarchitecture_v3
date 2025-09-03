package com.arka.cotizador.application.useCase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.arka.cotizador.domain.model.CotizacionResponse;
import com.arka.cotizador.domain.port.in.CotizacionUseCase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CotizacionApplicationService implements CotizacionUseCase {

    private WebClient webClient;

    public CotizacionApplicationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://localhost:8081/productos").build();
    }    
    
    @Override
    public Mono<CotizacionResponse> crearCotizacion(List<String> referenciasProductos){

        Mono<CotizacionResponse> response = Mono.just(new CotizacionResponse());

        Flux<Double> preciosProductos = Flux.fromIterable(referenciasProductos)
            .flatMap(ref -> webClient.get()
                .uri("/price/reactive/{ref}", ref)
                .retrieve()
                .bodyToMono(Double.class)
                .doOnEach(price -> System.out.println(ref + " " + price)));
        
        return response;
    }

}
