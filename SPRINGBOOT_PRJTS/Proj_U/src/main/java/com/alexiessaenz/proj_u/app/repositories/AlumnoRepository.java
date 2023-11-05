package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("alumnoRepository")
public interface AlumnoRepository extends PersonaRepository {
    @Query("SELECT a FROM Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Alumno> buscarAlumnoPorNombreCarrera(String nombreCarrera);
}
