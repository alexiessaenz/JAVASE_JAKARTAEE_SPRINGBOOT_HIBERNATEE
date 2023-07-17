package com.alexiessaenz.proj_u.app;

import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import org.springframework.boot.CommandLineRunner;

public class CarreraComandos implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Carrera carrera = new Carrera();
        carrera.setNombre("Ingeniería en Sistemas de Información");
        carrera.setCantAnios(5);
        carrera.setCantMaterias(40);
        Carrera save = new Carrera();
    }
}
