package com.alexiessaenz.springbootdatajpa.app.models.service;

import com.alexiessaenz.springbootdatajpa.app.models.daos.IClienteDao;
import com.alexiessaenz.springbootdatajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public Cliente findOneById(Long id) {
        return clienteDao.findOneById(id);
    }

    @Override
    public void remove(Long id) {
        clienteDao.remove(id);
    }
}
