package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.utils.ResponseObject;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.MetodoPagoUsuarioUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.dto.MetodoPagoUsuarioDto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.api.mapper.MetodoPagoUsuarioWebMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/metodosPagoUsuario")
@RequiredArgsConstructor
public class MetodoPagoUsuarioController {

    private final MetodoPagoUsuarioUseCase metodoPagoUsuarioUseCase;
    private final MetodoPagoUsuarioWebMapper mapper;

    private static ResponseObject<MetodoPagoUsuarioDto> rObjDto;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<MetodoPagoUsuarioDto>> getMetodosPagoByIdUsuario(
        @PathVariable("idUsuario") int idUsuario
    ) {
        List<MetodoPagoUsuario> metodosPagoUsuario = metodoPagoUsuarioUseCase.getMetodosPagoByIdUsuario(idUsuario);
        List<MetodoPagoUsuarioDto> metodosPagoUsuarioDto = metodosPagoUsuario.stream()
                                                            .map(mapper::toDto)
                                                            .toList();

        return ResponseEntity.ok(metodosPagoUsuarioDto);
    }

    @PostMapping("/createMetodoPagoUsuario/{idUsuario}/{idMetodoPago}")
    public ResponseEntity<ResponseObject<MetodoPagoUsuarioDto>> createMetodoPagoUsuario(
        @PathVariable("idUsuario") int idUsuario, @PathVariable("idMetodoPago") int idMetodoPago
    ) {
        rObjDto = new ResponseObject<>();

        ResponseObject<MetodoPagoUsuario> metodoPagoUsuarioCreated = metodoPagoUsuarioUseCase.createMetodoPagoUsuario(idUsuario, idMetodoPago);

        rObjDto.setSuccessful(metodoPagoUsuarioCreated.isSuccessful());
        rObjDto.setMessage(metodoPagoUsuarioCreated.getMessage());
        rObjDto.setObj(mapper.toDto(metodoPagoUsuarioCreated.getObj()));

        if(rObjDto.isSuccessful()){
            return ResponseEntity.ok(rObjDto);
        }

        return ResponseEntity.badRequest().body(rObjDto);
    }

    @PutMapping("/updateMetodoPagoUsuario/{idUsuario}/{idMetodoPago}/{valorCuenta}")
    public ResponseEntity<ResponseObject<MetodoPagoUsuarioDto>> updateMetodoPagoUsuario(
        @PathVariable("idUsuario") int idUsuario, @PathVariable("idMetodoPago") int idMetodoPago
        , @PathVariable("valorCuenta") double valorCuenta
    ) {
        rObjDto = new ResponseObject<>();

        ResponseObject<MetodoPagoUsuario> metodoPagoUsuarioUpdated = metodoPagoUsuarioUseCase.manageMetodoPagoUsuario(idUsuario, idMetodoPago, valorCuenta);
        rObjDto.setSuccessful(metodoPagoUsuarioUpdated.isSuccessful());
        rObjDto.setMessage(metodoPagoUsuarioUpdated.getMessage());
        rObjDto.setObj(mapper.toDto(metodoPagoUsuarioUpdated.getObj()));     
        
        if(rObjDto.isSuccessful()){
            return ResponseEntity.ok(rObjDto);
        }        
        
        return ResponseEntity.badRequest().body(rObjDto);
    }

    @DeleteMapping("/deleteMetodoPagoUsuario/{idUsuario}/{idMetodoPago}")
    public ResponseEntity<Void> deleteMetodoPagoUsuario (
        @PathVariable("idUsuario") int idUsuario, @PathVariable("idMetodoPago") int idMetodoPago
    ){
        if(metodoPagoUsuarioUseCase.deleteByIdUsuarioAndMetodoPago(idUsuario, idMetodoPago)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
