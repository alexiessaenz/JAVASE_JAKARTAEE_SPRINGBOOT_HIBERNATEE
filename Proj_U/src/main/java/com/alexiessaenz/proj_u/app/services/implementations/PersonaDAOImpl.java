package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.repositories.PersonaRepository;
import com.alexiessaenz.proj_u.app.services.contracts.IPersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona,PersonaRepository> implements IPersonaDAO {
    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return null;
    }

}

