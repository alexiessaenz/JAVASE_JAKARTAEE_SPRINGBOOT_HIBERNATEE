package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.services.contracts.GenericoDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class GenericoDAOImpl<E,R extends CrudRepository<E,Long>> implements GenericoDao<E> {
    protected final R repository;

    public GenericoDAOImpl(R repository) {
        this.repository = repository;
    }


    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }
}
