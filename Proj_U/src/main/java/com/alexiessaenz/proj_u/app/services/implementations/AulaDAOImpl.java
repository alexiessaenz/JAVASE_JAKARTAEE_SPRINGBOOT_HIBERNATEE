package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.models.entities.Aula;
import com.alexiessaenz.proj_u.app.models.entities.enums.Pizarron;
import com.alexiessaenz.proj_u.app.services.contracts.IAulaDAO;

import java.util.Optional;

public class AulaDAOImpl implements IAulaDAO {
    @Override
    public Iterable<Aula> findAulasByPizarron(Pizarron pizarron) {
        return null;
    }

    @Override
    public Iterable<Aula> findAulasByPavellonNombre(String nombre) {
        return null;
    }

    @Override
    public Optional<Aula> findAulaByNroAula(Integer nroAula) {
        return Optional.empty();
    }
}
