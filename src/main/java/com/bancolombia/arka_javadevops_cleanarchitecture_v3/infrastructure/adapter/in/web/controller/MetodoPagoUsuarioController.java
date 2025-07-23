package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.utils.ResponseObject;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.MetodoPagoUsuarioUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.dto.MetodoPagoUsuarioDto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.mapper.MetodoPagoUsuarioWebMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/metodosPagoUsuario")
@RequiredArgsConstructor
public class MetodoPagoUsuarioController {

    private final MetodoPagoUsuarioUseCase metodoPagoUsuarioUseCase;
    private final MetodoPagoUsuarioWebMapper mapper;

    private static ResponseObject<MetodoPagoUsuarioDto> rObjDto;

    @PostMapping("/createMetodoPagoUsuario/{idMetodoPago}/{idUsuario}")
    public ResponseEntity<ResponseObject<MetodoPagoUsuarioDto>> createMetodoPagoUsuario(
        @PathVariable("idMetodoPago") int idMetodoPago, @PathVariable("idUsuario") int idUsuario
    ) {
        rObjDto = new ResponseObject<>();

        ResponseObject<MetodoPagoUsuario> metodoPagoUsuarioCreated = metodoPagoUsuarioUseCase.createMetodoPagoUsuario(idMetodoPago, idUsuario);

        rObjDto.setSuccessful(metodoPagoUsuarioCreated.isSuccessful());
        rObjDto.setMessage(metodoPagoUsuarioCreated.getMessage());
        rObjDto.setObj(mapper.toDto(metodoPagoUsuarioCreated.getObj()));

        return ResponseEntity.ok(rObjDto);
    }
    

}
