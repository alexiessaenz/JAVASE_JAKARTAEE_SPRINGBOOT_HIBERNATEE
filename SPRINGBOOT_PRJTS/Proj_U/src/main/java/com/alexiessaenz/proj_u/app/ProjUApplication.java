package com.alexiessaenz.proj_u.app;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Direccion;
import com.alexiessaenz.proj_u.app.models.entities.Persona;
import com.alexiessaenz.proj_u.app.models.entities.Profesor;
import com.alexiessaenz.proj_u.app.services.implementations.AlumnoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjUApplication {


    public static void main(String[] args) {
       String[] beans = SpringApplication
                .run(ProjUApplication.class, args)
                .getBeanDefinitionNames();



//        for (String str : args) {
//            System.out.println(str);
//        }
//
//        Arrays.stream(beans).filter(
//                str -> str.contains("Repository")
//        ).forEach(System.out::println);


    }
    @Bean
    public CommandLineRunner runner(){
        return arg -> {
           /* Direccion direccion = new Direccion();
            direccion.setCalle("Calle 1");
            direccion.setNumero("123");
            direccion.setCodigoPostal("12345");

            Persona p = new Alumno();
            p.setNombre("Alexis");
            p.setApellido("Saenz");
            p.setDni("123456789");

            Persona saved = alumnoDAOImpl.save(p);
            System.out.println(saved);

            System.out.println(alumnoDAOImpl.findAll());*/

        };
    }

}
