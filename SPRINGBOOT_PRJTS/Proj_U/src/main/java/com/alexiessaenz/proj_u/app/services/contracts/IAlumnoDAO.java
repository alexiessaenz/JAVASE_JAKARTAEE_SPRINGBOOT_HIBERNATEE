package com.alexiessaenz.proj_u.app.services.contracts;

import com.alexiessaenz.proj_u.app.models.entities.Persona;

import java.util.Optional;

public interface IAlumnoDAO {
    Iterable<Persona> buscarAlumnosPorNomnbreCarrera(String nombre);



}
