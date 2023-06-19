package org.tbsJunit.jpaHib.repositories;

import org.tbsJunit.jpaHib.entities.Cliente;

import java.util.List;

public interface CrudRepository {
    public List<Cliente> listar();
    public Cliente porId(Long id );
    public void guardar(Cliente cliente);
    public void eliminar(Long id);

}
