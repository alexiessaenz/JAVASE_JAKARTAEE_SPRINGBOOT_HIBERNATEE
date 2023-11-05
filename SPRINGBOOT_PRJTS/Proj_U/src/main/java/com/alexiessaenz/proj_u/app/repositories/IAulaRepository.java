package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Aula;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.models.entities.enums.Pizarron;
import com.alexiessaenz.proj_u.app.models.entities.enums.TipoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("aulaRepository")
public interface IAulaRepository extends JpaRepository<Aula,Integer> {
    Iterable<Aula> findAulasByPizarron(Pizarron pizarron);

//    @Query("select a from Aula a where a.pavellon.nombre = ?1")
    @Query("SELECT a FROM Aula a join fetch a.pavellon p where p.nombre = ?1")
    Iterable<Aula> findAulasByPavellon(String nombre);
    Optional<Aula> findByNroAula(Integer numero);

}
