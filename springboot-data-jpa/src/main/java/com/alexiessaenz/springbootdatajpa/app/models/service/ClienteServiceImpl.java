package com.alexiessaenz.springbootdatajpa.app.models.service;

import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        Sort sortOrder = Sort.by("nombre");
        clienteDao.findAll(sortOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOneById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }}
