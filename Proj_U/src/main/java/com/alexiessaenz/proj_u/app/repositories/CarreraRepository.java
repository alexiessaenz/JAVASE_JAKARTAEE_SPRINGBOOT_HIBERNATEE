package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera,Long>{
    //@Query("SELECT c FROM Carrera c WHERE c.nombre like %?1%")
    Iterable<Carrera> findCarreraByNombreContains(String nombre);
    //Query("SELECT c FROM Carrera c WHERE upper (c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarreraByNombreIgnoreCase(String nombre);
    Iterable<Carrera> findCarreraByCantAniosAfter(Integer cantAnios);

    @Query("SELECT c FROM Carrera c join fetch c.profesores p where p.nombre = ?1 and p.apellido = ?2")
    Iterable<Carrera> buscarCarrerasByProfesorNombreYApellido(String nombre, String apellido);

//    Iterable<Carrera> findByNombreOrderByProfesores_NombreAscProfesores_ApellidoAsc(String nombre);


}
