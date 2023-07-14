package com.alexiessaenz.proj_u.app;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Direccion;
import com.alexiessaenz.proj_u.app.models.entities.Professor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjUApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjUApplication.class, args);
        Direccion d = new Direccion();
        Alumno a = new Alumno();
        Professor p = new Professor();

    }

}
