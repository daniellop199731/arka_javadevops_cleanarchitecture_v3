package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.port.in;

import java.util.List;
import com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model.Cliente;

public interface ClienteUserCase {

    List<Cliente> getAllClientes();
    Cliente getClienteById(int idCliente);
    Cliente createCliente(Cliente Cliente);
    Cliente updateCliente(int idCliente, Cliente Cliente);
    boolean deleteCliente(int idCliente);
    Cliente getClienteByIdentificacion(String identificacionCliente);
    boolean canUpdateCliente(String identificacionCliente, int idCliente);
    
}

