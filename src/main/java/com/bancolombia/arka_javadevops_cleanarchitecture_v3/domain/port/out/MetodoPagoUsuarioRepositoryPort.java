package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;

public interface MetodoPagoUsuarioRepositoryPort {

    List<MetodoPagoUsuario> findByUsuarioMetodoPago(Usuario usuario);
    MetodoPagoUsuario save(MetodoPagoUsuario metodoPagoUsuario);
    MetodoPagoUsuario update(int id, MetodoPagoUsuario metodoPagoUsuario);


}
