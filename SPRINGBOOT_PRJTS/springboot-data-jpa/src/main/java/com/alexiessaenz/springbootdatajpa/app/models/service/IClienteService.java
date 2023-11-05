package com.alexiessaenz.springbootdatajpa.app.models.service;

import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    Page<Cliente> findAll(Pageable pageable);
    @Transactional()
    void save(Cliente cliente);
    @Transactional()
    Cliente findOne(Long id);
    @Transactional()
    void delete(Long id);
}
