package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import org.springframework.beans.factory.annotation.Autowired;

public class CarreraDAOImpl extends GenericoDAOImpl
    <Carrera, CarreraRepository> implements ICarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }
}
