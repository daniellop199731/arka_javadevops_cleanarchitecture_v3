package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;

import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Proveedor;

public interface ProveedorUseCase {

    List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(int idProveedor);
    Proveedor createProveedor(Proveedor proveedor);
    Proveedor updateProveedor(int idProveedor, Proveedor proveedor);
    boolean deleteProveedorById(int idProveedor);
    
}
