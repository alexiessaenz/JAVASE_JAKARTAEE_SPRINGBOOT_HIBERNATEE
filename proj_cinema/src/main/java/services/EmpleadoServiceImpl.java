package services;

import org.jpahibernateexam.entities.Empleado;
import org.jpahibernateexam.repositories.EmpleadoRepository;

import java.util.List;

public class EmpleadoServiceImpl implements IEmpleadoService {
    EmpleadoRepository empleadoRepository = new EmpleadoRepository();
    private Empleado emp;

    public EmpleadoServiceImpl() {
    }

    @Override
    public List<Empleado> listar() throws Exception{
        try {
            return empleadoRepository.listar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Empleado porId(Long id) throws Exception{
        try {
            return empleadoRepository.porId(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void crear(Empleado empleado) throws Exception{
        empleadoRepository.crear(empleado);
    }

    @Override
    public void eliminar(long id) throws Exception{
            emp = empleadoRepository.porId(id);
            if (emp == null) throw new Exception("No existe el empleado con el id " + id);
            empleadoRepository.eliminar(id);
    }

    @Override
    public void editar(Empleado empleado) throws Exception{
            empleadoRepository.editar(empleado);
    }
}
