package com.alexiessaenz.springbootdatajpa.app.models.daos;

import com.alexiessaenz.springbootdatajpa.app.entities.Cliente;

import java.util.List;

public interface IClienteDao {

    public List<Cliente> findAll();
}
