package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.repositories.AlumnoRepository;
import com.alexiessaenz.proj_u.app.repositories.PersonaRepository;
import com.alexiessaenz.proj_u.app.repositories.AlumnoRepository;
import com.alexiessaenz.proj_u.app.services.contracts.IAlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Qualifier("alumnoDAOImpl")
public class AlumnoDAOImpl extends PersonaDAOImpl implements IAlumnoDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("alumnoRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Persona> buscarAlumnosPorNomnbreCarrera(String nombre) {
        return Optional.empty();
    }
}