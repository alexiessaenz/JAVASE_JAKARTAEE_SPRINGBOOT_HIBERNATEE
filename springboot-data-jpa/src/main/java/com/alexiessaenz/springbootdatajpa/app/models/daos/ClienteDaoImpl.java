package com.alexiessaenz.springbootdatajpa.app.models.daos;

import com.alexiessaenz.springbootdatajpa.app.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@NoArgsConstructor
@Repository("clienteDaoJpa")
public class ClienteDaoImpl implements IClienteDao{
    @PersistenceContext
    private EntityManager em;

    //@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }
    @Transactional()
    @Override
    public void save(Cliente c) {
        System.out.println(c);
       // Cliente c = findOneById(cliente.getId());
//        if(cliente.getEmail()==null)
//            em.persist(cliente);
//        else
//            Cliente c = findOneById(cliente.getId());
//            em.merge(cliente);

        if(c.getId()==null || c.getId()<0)

            em.persist(c);
        else
            em.merge(c);
    }

    @Override
    public Cliente findOneById(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        em.remove(
                findOneById(id)
        );
    }
}
