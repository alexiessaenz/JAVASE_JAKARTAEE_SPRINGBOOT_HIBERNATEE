package com.alexiessaenz.proj_u.app.services.contracts;

import java.util.Optional;

public interface GenericoDao<E> {
    Optional<E> findById(Long id);
    E save(E e);
    void deleteById(Long id);
    Iterable<E> findAll();

}
