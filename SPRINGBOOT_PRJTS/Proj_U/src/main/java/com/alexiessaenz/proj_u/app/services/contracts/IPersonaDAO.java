package com.alexiessaenz.proj_u.app.services.contracts;

import com.alexiessaenz.proj_u.app.models.entities.Persona;

import java.util.Optional;

public interface IPersonaDAO extends GenericoDao<Persona>{
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
