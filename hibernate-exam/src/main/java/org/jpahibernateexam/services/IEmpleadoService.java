package org.jpahibernateexam.services;

import org.jpahibernateexam.entities.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> listar();
    Empleado porId(Long id);

    void editar(Empleado empleado);
    void crear(Empleado empleado);
    void eliminar(long id);
}
