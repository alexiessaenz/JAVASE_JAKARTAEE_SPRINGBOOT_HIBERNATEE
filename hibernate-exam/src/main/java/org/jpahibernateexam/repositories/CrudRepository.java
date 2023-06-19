package org.jpahibernateexam.repositories;

import org.jpahibernateexam.entities.Empleado;

import java.util.List;

public interface CrudRepository {
    List<Empleado> listar();
    Empleado porId(Long id);
    void editar(Empleado empleado) throws Exception;
    void crear(Empleado empleado) throws Exception;
    void eliminar(long id) throws Exception;
}
