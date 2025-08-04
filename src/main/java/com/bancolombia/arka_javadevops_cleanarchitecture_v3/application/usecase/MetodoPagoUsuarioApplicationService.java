package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.utils.ResponseObject;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPago;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.MetodoPagoUsuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Usuario;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.MetodoPagoUsuarioUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.MetodoPagoRepositoryPort;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.MetodoPagoUsuarioRepositoryPort;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetodoPagoUsuarioApplicationService implements MetodoPagoUsuarioUseCase {

    private final MetodoPagoUsuarioRepositoryPort metodoPagoUsuarioRepositoryPort;
    private final MetodoPagoRepositoryPort metodoPagoRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    private static ResponseObject<MetodoPagoUsuario> rObj;

    @Override
    public List<MetodoPagoUsuario> getMetodosPagoByIdUsuario(int idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return metodoPagoUsuarioRepositoryPort.findByUsuarioMetodoPago(usuario);
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> createMetodoPagoUsuario(int idUsuario, int idMetodoPago) {
        rObj = new ResponseObject<>();

        if(!usuarioRepositoryPort.existsById(idUsuario)){
            rObj.setAsNotSuccessful("No existe el Usuario con id " + idUsuario);
            return rObj;
        }

        if(!metodoPagoRepositoryPort.existsById(idMetodoPago)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(metodoPagoUsuarioRepositoryPort.existByIdUsuarioAndMetodoPago(idUsuario, idMetodoPago)){
            rObj.setAsNotSuccessful("Ya existe la asignacion");
            return rObj;
        }

        MetodoPagoUsuario metodoPagoUsuario = new MetodoPagoUsuario();

        Usuario usuarioMetodoPago = new Usuario();
        usuarioMetodoPago.setIdUsuario(idUsuario);
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(idMetodoPago);

        metodoPagoUsuario.setUsuarioMetodoPago(usuarioMetodoPago);
        metodoPagoUsuario.setMetodoPago(metodoPago);

        rObj.setAsSuccessful("Se agrego el metodo de pago al usuario con exito"
                            , metodoPagoUsuarioRepositoryPort.save(metodoPagoUsuario));

        return rObj;
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> manageMetodoPagoUsuario(int idUsuario, int idMetodoPago,
            double valorCuenta) {

        rObj = new ResponseObject<>();

        if(!metodoPagoRepositoryPort.existsById(idMetodoPago)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(!usuarioRepositoryPort.existsById(idUsuario)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(valorCuenta <= 0){
            rObj.setAsNotSuccessful("El valor a cargar debe ser mayor a cero");
            return rObj;
        }

        MetodoPagoUsuario metodoPagoUsuario = new MetodoPagoUsuario();
        Usuario usuarioMetodoPago = new Usuario();
        usuarioMetodoPago.setIdUsuario(idUsuario);
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(idMetodoPago);

        metodoPagoUsuario.setUsuarioMetodoPago(usuarioMetodoPago);
        metodoPagoUsuario.setMetodoPago(metodoPago);
        metodoPagoUsuario.setValorCuentaMetodoPago(valorCuenta);

        Optional<MetodoPagoUsuario> metodoPagoUsuarioFinded = metodoPagoUsuarioRepositoryPort.findByIdUsuarioAndIdMetodoPago(idUsuario, idMetodoPago);
        String msg = "Se agrego el metodo de pago al usuario con exito";

        if(metodoPagoUsuarioFinded.isPresent()){
            metodoPagoUsuario.setId(metodoPagoUsuarioFinded.get().getId());
            metodoPagoUsuario.setValorCuentaMetodoPago(metodoPagoUsuarioFinded.get().getValorCuentaMetodoPago() + valorCuenta);
            msg = "Se realizó la actualizacíon con exíto";
        }

        rObj.setAsSuccessful(msg ,metodoPagoUsuarioRepositoryPort.save(metodoPagoUsuario));
        return rObj;
    }

    @Override
    public boolean deleteByIdUsuarioAndMetodoPago(int idUsuario,
            int idMetodoPago) {
        Optional<MetodoPagoUsuario> metodoPagoUsuario = metodoPagoUsuarioRepositoryPort.findByIdUsuarioAndIdMetodoPago(idUsuario, idMetodoPago);
        if(metodoPagoUsuario.isPresent()){
            metodoPagoUsuarioRepositoryPort.deleteById(metodoPagoUsuario.get().getId());
            return true;
        }
        return false;
    }

}
