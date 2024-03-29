package com.alexiessaenz.proj_u.app.Commands;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.services.contracts.IAlumnoDAO;
import com.alexiessaenz.proj_u.app.services.contracts.ICarreraDAO;
import com.alexiessaenz.proj_u.app.services.implementations.AlumnoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CarreraComandos implements CommandLineRunner {
//    @Autowired
//    @Qualifier("alumnoDAOImpl")
//    private IAlumnoDAO personaDAO;
    @Autowired
    private ICarreraDAO servicio;


    @Override
    public void run(String... args) throws Exception {
       Carrera carrera = new Carrera();
        carrera.setNombre("Ingeniería en Sistemas de Información");
        carrera.setCantAnios(5);
        carrera.setCantMaterias(40);
        Carrera save = new Carrera();

//        Optional<Persona> persona = personaDAO.findById(1L);
//        if(persona.isPresent()){
//            Persona p = persona.get();
//            System.out.println(p);
//        }

        Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        servicio.save(ingSistemas);
        servicio.save(ingIndustrial);
        servicio.save(ingAlimentos);
        servicio.save(ingElectronica);
        servicio.save(licSistemas);
        servicio.save(licTurismo);
        servicio.save(licYoga);
        servicio.save(licRecursos);
    }
}
