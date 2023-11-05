package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.models.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("profesorRepository")
public interface IProfesorRepository extends JpaRepository<Profesor,Long> {
    @Query("SELECT p FROM Profesor p join fetch p.carreras c where c.nombre = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
