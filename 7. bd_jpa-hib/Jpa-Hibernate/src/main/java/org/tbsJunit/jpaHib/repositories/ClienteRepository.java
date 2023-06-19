package org.tbsJunit.jpaHib.repositories;

import jakarta.persistence.EntityManager;
import org.tbsJunit.jpaHib.entities.Cliente;

import java.util.List;

public class ClienteRepository implements CrudRepository{

    private EntityManager em;

    public ClienteRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Cliente> listar(){
        return em.createQuery("select c from Cliente c",
                Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Long id ){
        return em.find(Cliente.class,id);
    }

    @Override
    public void guardar(Cliente cliente){
        if(cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Override
    public void eliminar(Long id){
        Cliente cliente = porId(id);
        em.remove(cliente);
    }
}
