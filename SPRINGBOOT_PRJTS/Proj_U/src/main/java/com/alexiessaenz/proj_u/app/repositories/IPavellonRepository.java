package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Pavellon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("pavellonRepository")
public interface IPavellonRepository extends JpaRepository<Pavellon, Integer> {
    @Query("SELECT p FROM Pavellon p WHERE p.direccion.localidad = ?1")
    Iterable<Pavellon> findPavellonsByLocalidad(String nombre);
    @Query("SELECT p FROM Pavellon p WHERE p.nombre = ?1")
    Iterable<Pavellon> findPavellonsByNombre(String nombre);
}
