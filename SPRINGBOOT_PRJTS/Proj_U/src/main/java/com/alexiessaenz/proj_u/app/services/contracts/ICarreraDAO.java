package com.alexiessaenz.proj_u.app.services.contracts;

import com.alexiessaenz.proj_u.app.models.entities.Carrera;

public interface ICarreraDAO extends GenericoDao<Carrera> {
    Iterable<Carrera> findCarreraByNombreContains(String nombre);
    Iterable<Carrera> findCarreraByNombreIgnoreCase(String nombre);
    Iterable<Carrera> findCarreraByCantAniosAfter(Integer cantAnios);

}
