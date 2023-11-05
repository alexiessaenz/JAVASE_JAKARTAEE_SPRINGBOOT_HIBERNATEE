package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    @Query("select p from Persona p where p.dni = ?1")
    Optional<Persona> buscarPorDni(String dni);
    @Query("select p from Persona p where p.apellido like %?1%")
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
