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

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }
    @Transactional(readOnly = true)
    @Override
    public void save(Cliente cliente) {
        em.persist(cliente);
    }
}
