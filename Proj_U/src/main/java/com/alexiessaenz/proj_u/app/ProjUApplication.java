package com.alexiessaenz.proj_u.app;

import com.alexiessaenz.proj_u.app.models.entities.Alumno;
import com.alexiessaenz.proj_u.app.models.entities.Direccion;
import com.alexiessaenz.proj_u.app.models.entities.Profesor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjUApplication {

    public static void main(String[] args) {
       String[] beans = SpringApplication
                .run(ProjUApplication.class, args)
                .getBeanDefinitionNames();

        for (String str : args) {
            System.out.println(str);
        }

        Arrays.stream(beans).filter(
                str -> str.contains("Repository")
        ).forEach(System.out::println);


    }

}
