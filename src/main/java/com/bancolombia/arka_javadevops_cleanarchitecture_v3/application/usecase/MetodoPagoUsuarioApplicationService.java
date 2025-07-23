package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;

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
    public ResponseObject<MetodoPagoUsuario> createMetodoPagoUsuario(int idMetodoPago, int idUsuario) {
        rObj = new ResponseObject<>();

        if(!metodoPagoRepositoryPort.existsById(idMetodoPago)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        if(!usuarioRepositoryPort.existsById(idUsuario)){
            rObj.setAsNotSuccessful("No existe el Metodo de pago con id " + idMetodoPago);
            return rObj;
        }

        MetodoPagoUsuario metodoPagoUsuario = new MetodoPagoUsuario();
        MetodoPago metodoPago = new MetodoPago();
        Usuario usuario = new Usuario();

        metodoPago.setIdMetodoPago(idMetodoPago);
        usuario.setIdUsuario(idUsuario);
        metodoPagoUsuario.setMetodoPago(metodoPago);
        metodoPagoUsuario.setUsuarioMetodoPago(usuario);

        rObj.setAsSuccessful("Se agrego el metodo de pago al usuario con exito"
                            , metodoPagoUsuarioRepositoryPort.save(metodoPagoUsuario));

        return rObj;
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> updateValorCuentaById(int id, double valorCuenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateValorCuentaById'");
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> updateValorCuentaByIdUsuarioIdMetodoPago(int idUsuario, int idMetodoCuenta,
            double valorCuenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateValorCuentaByIdUsuarioIdMetodoPago'");
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> deleteMetodoPagoUsuario(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMetodoPagoUsuario'");
    }

    @Override
    public ResponseObject<MetodoPagoUsuario> deleteValorCuentaByIdUsuarioIdMetodoPago(int idUsuario,
            int idMetodoCuenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteValorCuentaByIdUsuarioIdMetodoPago'");
    }

}
