package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.out.persistence.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carritosCompra")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarritoCompra;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCarritoCompra")
    private UsuarioEntity usuarioCarritoCompra;

    @ManyToOne
    @JoinColumn(name = "idEstadoDespachoCarritoCompra")
    @Nullable
    private EstadoDespachoEntity estadoDespachoCarritoCompra;

    @ManyToOne
    @JoinColumn(name = "idMetodoPagoCarritoCompra")
    @Nullable
    private MetodoPagoEntity metodoPagoCarritoCompra;

    //0: para carrito no pagado, 1: para carrito pagado
    private int carritoPagado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacionCarritoCompra;

    private int cantidadNotificacionesPorCarritoAbandonado; 
    
    @PrePersist
    public void toCreate(){
        setFechaCreacionCarritoCompra(new Date());
        setCarritoPagado(0);
        setCantidadNotificacionesPorCarritoAbandonado(0);
    }    

}
