package com.alexiessaenz.proj_u.app.Commands;

import com.alexiessaenz.proj_u.app.models.entities.*;
import com.alexiessaenz.proj_u.app.models.entities.enums.Pizarron;

import java.math.BigDecimal;

public class ObjetosDummy {
    public static Aula getAula123(){
        return new Aula(null, 123, "24 x 36", 50, Pizarron.PIZARRA_BLANCA);
    }

    public static Aula getAula231(){
        return new Aula(null, 231, "20 x 30", 50, Pizarron.PIZARRA_TIZA);
    }

    public static Aula getAula451(){
        return new Aula(null, 451, "15 x 25", 50, Pizarron.PIZARRA_BLANCA);
    }

    public static Pavellon getPavellonUno(){
        return new Pavellon(null, 450.5, "Pavellon Uno", new Direccion("Calle Uno", "1453", "1623", "", "", "Rodriguez Peña"));
    }

    public static Pavellon getPavellonDos(){
        return new Pavellon(null, 750.0, "Pavellon Dos", new Direccion("Calle Dos", "584", "1623", "", "", "Rodriguez Peña"));
    }

    public static Carrera getCarreraIngSis(){
        return new Carrera(null, "Ingenieria en Sistemas", 60, 5);
    }

    public static Carrera getCarreraLicTur(){
        return new Carrera(null, "Licenciatura en Turismo", 42, 4);
    }

    public static Persona getAlumnoUno(){
        return new Alumno(null, "Lautaro", "Gimenez", "34562189", new Direccion());
    }

    public static Persona getAlumnoDos(){
        return new Alumno(null, "Laura", "Videla", "32159753", new Direccion());
    }

 /*   public static Persona getProfesorUno(){
        return new Profesor(null, "Horacio", "Laurin", "22695142", new Direccion(), new BigDecimal("25600"));
    }

    public static Persona getProfesorDos(){
        return new Profesor(null, "Ruben", "Gonzalez", "25943608", new Direccion(), new BigDecimal("23500"));
    }

    public static Persona getEmpleadoUno(){
        return new Empleado(null, "Lucrecia","Dominguez", "30942108", new Direccion(), new BigDecimal("15600"), TipoEmpleado.ADMINISTRATIVO);
    }
    public static Persona getEmpleadoDos(){
        return new Empleado(null, "Roberto", "Lugones", "28902674", new Direccion(), new BigDecimal("14250"), TipoEmpleado.MANTENIMIENTO);
    }*/
}
