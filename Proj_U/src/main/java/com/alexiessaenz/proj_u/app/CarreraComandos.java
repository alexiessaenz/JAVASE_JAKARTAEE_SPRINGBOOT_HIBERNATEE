package com.alexiessaenz.proj_u.app;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.services.contracts.IAlumnoDAO;
import com.alexiessaenz.proj_u.app.services.implementations.AlumnoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CarreraComandos implements CommandLineRunner {
    @Autowired
//    @Qualifier("alumnoDAOImpl")
    private IAlumnoDAO personaDAO;


    @Override
    public void run(String... args) throws Exception {
       /* Carrera carrera = new Carrera();
        carrera.setNombre("Ingeniería en Sistemas de Información");
        carrera.setCantAnios(5);
        carrera.setCantMaterias(40);
        Carrera save = new Carrera();*/

        Optional<Persona> persona = personaDAO.findById(1L);
        if(persona.isPresent()){
            Persona p = persona.get();
            System.out.println(p);
        }
    }
}
