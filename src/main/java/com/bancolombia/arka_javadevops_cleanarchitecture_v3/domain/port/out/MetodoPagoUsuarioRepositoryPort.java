package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

public interface MetodoPagoUsuarioRepositoryPort {

    List<MetodoPagoUsuario> findByUsuarioMetodoPago(Usuario usuario);
    Optional<MetodoPagoUsuario> findByIdUsuarioAndIdMetodoPago(int idUsuarioMetodoPago, int idMetodoPago);
    MetodoPagoUsuario save(MetodoPagoUsuario metodoPagoUsuario);
    boolean existByIdUsuarioAndMetodoPago(int idUsuarioMetodoPago, int idMetodoPago);
    void deleteById(int idMetodoPagoUsuario);

}
