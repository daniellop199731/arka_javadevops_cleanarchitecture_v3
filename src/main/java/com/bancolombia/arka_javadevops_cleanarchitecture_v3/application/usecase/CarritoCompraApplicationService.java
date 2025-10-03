package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.CarritoCompra;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Cliente;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.EstadoDespacho;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.CarritoCompraUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.ClienteUserCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.CarritoCompraRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarritoCompraApplicationService implements CarritoCompraUseCase {

    private final CarritoCompraRepositoryPort repositoryPort;

    private final ClienteUserCase clienteUserCase;

    @Override
    public CarritoCompra crearNuevo(int idCliente) {
        Cliente cliente = clienteUserCase.getClienteById(idCliente);
        CarritoCompra carritoCompra = this.carritoActual(idCliente);
        //Si el cliente existe y no tiene carrito de compra actual
        if(cliente.getIdCliente() > 0 && carritoCompra.getIdCarritoCompra() <= 0){
            //Se crea un nuevo carrito de compra
            EstadoDespacho estadoDespacho = new EstadoDespacho();
            estadoDespacho.setIdEstadoDespacho(1);
            carritoCompra.setClienteCarritoCompra(cliente);
            carritoCompra.setEstadoDespacho(estadoDespacho);
            carritoCompra = repositoryPort.save(carritoCompra);
        }
        //Se devuelve el carrito de compra actual nuevo o el existente si ya tiene
        return carritoCompra;
    }  

    @Override
    public CarritoCompra obtenerCarritoPorId(int idCarritoCompra) {
        Optional<CarritoCompra> carritoCompraFinded = repositoryPort.findById(idCarritoCompra);
        if(carritoCompraFinded.isPresent()){
            return carritoCompraFinded.get();
        }
        return new CarritoCompra();
    }

    @Override
    public List<CarritoCompra> carritosPorUsuario(int idCliente) {
        Cliente cliente = clienteUserCase.getClienteById(idCliente);
        if(cliente.getIdCliente() > 0){
            return repositoryPort.findByClienteCarritoCompra(cliente);
        }        
        return new ArrayList<>();
    }

    @Override
    public CarritoCompra carritoActual(int idCliente) {
        List<CarritoCompra> carritosCompra = repositoryPort.findCarritoActual(idCliente);
        if(carritosCompra.isEmpty()){
            return new CarritoCompra();
        }
        return carritosCompra.get(0);
    }

    @Override
    public List<CarritoCompra> carritosAbandonados() {
        return repositoryPort.findcarritosAbandonados();
    }

    @Override
    public List<CarritoCompra> carritoComprasPorFechas(Date startDate, Date finishDate) {
        return repositoryPort.findByFechaCreacionCarritoCompraBetween(startDate, finishDate);
    }
    
}
