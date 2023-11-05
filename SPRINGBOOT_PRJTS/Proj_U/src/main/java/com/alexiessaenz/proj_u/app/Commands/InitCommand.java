package com.alexiessaenz.proj_u.app.Commands;

import com.alexiessaenz.proj_u.app.services.contracts.IPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class InitCommand {

    @Autowired
    @Qualifier(value = "alumnoDAOImpl")
    private IPersonaDAO servicioAlumno;
//    @Autowired
//    @Qualifier(value = "empleadoDAOImple")
//    private PersonaDAO servicioEmpleado;
//    @Autowired
//    @Qualifier(value = "profesorDAOImple")
//    private PersonaDAO servicioProfesor;
//    @Autowired
//    private AulaDAO servicioAula;
//    @Autowired
//    private PabellonDAO servicioPabellon;
//    @Autowired
//    private CarreraDAO servicioCarrera;
}
