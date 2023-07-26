package com.alexiessaenz.proj_u.app.repositories;

import com.alexiessaenz.proj_u.app.models.entities.Empleado;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.models.entities.enums.TipoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
//    Iterable<Empleado> findByTipoEmpleado(TipoEmpleado tipoEmpleado);
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
