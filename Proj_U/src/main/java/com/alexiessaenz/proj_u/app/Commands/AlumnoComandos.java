package com.alexiessaenz.proj_u.app.Commands;

import com.alexiessaenz.proj_u.app.Commands.ObjetosDummy;
import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.services.contracts.IAlumnoDAO;
import com.alexiessaenz.proj_u.app.services.contracts.ICarreraDAO;
import com.alexiessaenz.proj_u.app.services.contracts.IPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(value = 4) // Orden de ejecución de los comandos
public class AlumnoComandos implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private IPersonaDAO personaDAO;
    @Autowired
    @Qualifier("carreraDAOImpl")
    private ICarreraDAO carreraDAO;

    //busqueda por apellido
    @Override
    public void run(String... args) throws Exception {
        Iterable<Persona> ipersona = personaDAO.buscarPersonaPorApellido(
                ObjetosDummy.getAlumnoDos().getApellido()
        );

        //busqueda por dni
        Optional<Persona> opersona = personaDAO.buscarPorDni(
                ObjetosDummy.getAlumnoDos().getDni()
        );

//        opersona.ifPresent(persona -> System.out.println(persona.toString()));


        if (opersona.isPresent()) {
            System.out.println(opersona.get().toString());
        }

        //busqueda por nombre y apellido
        Optional<Persona> opersona2 = personaDAO.buscarPorNombreYApellido(
                ObjetosDummy.getAlumnoDos().getNombre(),
                ObjetosDummy.getAlumnoDos().getApellido()
        );

        if (opersona2.isPresent()) {
            System.out.println(opersona2.get().toString());
        }

        //busqueda de alumnos por carrera
        Iterable<Persona> iAlumnos = ((IAlumnoDAO) personaDAO).buscarAlumnosPorNomnbreCarrera(
                ObjetosDummy.getCarreraIngSis().getNombre()
        );

//        iAlumnos.forEach(persona -> System.out.println(persona.toString()));
        if (iAlumnos != null) {
            iAlumnos.forEach(System.out::println);
        }
    }
}
