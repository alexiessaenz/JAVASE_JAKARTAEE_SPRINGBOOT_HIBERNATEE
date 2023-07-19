package com.alexiessaenz.proj_u.app.services.contracts;

import com.alexiessaenz.proj_u.app.models.entities.Aula;
import com.alexiessaenz.proj_u.app.models.entities.enums.Pizarron;

import java.util.Optional;

public interface IAulaDAO {
    Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulasByPavellonNombre(String nombre);
    Optional<Aula> findAulaByNroAula(Integer nroAula);
}
