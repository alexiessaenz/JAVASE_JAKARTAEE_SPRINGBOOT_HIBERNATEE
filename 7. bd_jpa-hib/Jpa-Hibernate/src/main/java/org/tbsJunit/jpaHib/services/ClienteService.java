package org.tbsJunit.jpaHib.services;

import org.tbsJunit.jpaHib.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    void guardar(Cliente cliente);

}
