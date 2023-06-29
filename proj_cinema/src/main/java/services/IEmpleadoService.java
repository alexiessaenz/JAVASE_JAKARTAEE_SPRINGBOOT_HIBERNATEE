package services;

import org.jpahibernateexam.entities.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> listar()throws Exception;
    Empleado porId(Long id)throws Exception;

    void editar(Empleado empleado)throws Exception;
    void crear(Empleado empleado)throws Exception;
    void eliminar(long id)throws Exception;
}
