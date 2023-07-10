package com.alexiessaenz.springbootdatajpa.app.models.daos;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
    @Transactional()
    void save(Cliente cliente);
    @Transactional()
    Cliente findOneById(Long id);
    @Transactional()
    void remove(Long id);
}
