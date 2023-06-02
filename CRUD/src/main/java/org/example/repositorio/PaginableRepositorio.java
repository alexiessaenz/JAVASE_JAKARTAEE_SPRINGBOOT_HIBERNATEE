package org.example.repositorio;

import org.example.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar( int desde, int hasta);
}
