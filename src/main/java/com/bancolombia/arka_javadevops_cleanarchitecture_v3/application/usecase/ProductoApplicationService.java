package com.bancolombia.arka_javadevops_cleanarchitecture_v3.application.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Producto;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in.ProductoUseCase;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.out.ProductoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoApplicationService implements ProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public Producto getProductoById(int idProducto) {
        if(productoRepositoryPort.existById(idProducto)){    
            return productoRepositoryPort.findById(idProducto).get();
        }
        return new Producto();
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepositoryPort.save(producto);
    }

    @Override
    public Producto updateProducto(int idProducto, Producto producto) {
        if(productoRepositoryPort.existById(idProducto)){
            producto.setIdProducto(idProducto);
            return productoRepositoryPort.save(producto);
        }
        return new Producto();
    }

    @Override
    public boolean deleteProducto(int idProducto) {
        if(productoRepositoryPort.existById(idProducto)){
            productoRepositoryPort.deleteById(idProducto);
            return true;
        }
        return false;
    }

    @Override
    public Producto increaseStock(int idProducto, int stock) {
        Optional<Producto> producto = productoRepositoryPort.findById(idProducto);
        if(producto.isPresent()){
            Producto productoFinded = producto.get();
            productoFinded.setStockProducto(productoFinded.getStockProducto() + stock);
            return productoRepositoryPort.save(productoFinded);
        }
        return new Producto();
    }

    @Override
    public Producto decreaseStock(int idProducto, int stock) {
        Optional<Producto> producto = productoRepositoryPort.findById(idProducto);
        if(producto.isPresent()){
            Producto productoFinded = producto.get();
            if(productoFinded.getStockProducto() - stock <= productoFinded.getStockMinimoProducto()){
                //Reactive: Realizar solicitud de unidades del producto 
                //Unidades a solicitar en productoFinded.getUnidadesSolicitudProducto()
            }

            if(productoFinded.getStockProducto() - stock > 0){
                productoFinded.setStockProducto(productoFinded.getStockProducto() - stock);
            } else{
                productoFinded.setStockProducto(0);
            }
            
            return productoRepositoryPort.save(productoFinded);
        }
        return new Producto();
    }

}
