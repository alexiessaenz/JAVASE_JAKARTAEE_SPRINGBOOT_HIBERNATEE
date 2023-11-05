package com.alexiessaenz.proj_u.app.services.implementations;

import com.alexiessaenz.proj_u.app.models.entities.Carrera;
import com.alexiessaenz.proj_u.app.repositories.CarreraRepository;
import com.alexiessaenz.proj_u.app.services.contracts.ICarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("carreraDAOImpl")
public class CarreraDAOImpl extends GenericoDAOImpl
    <Carrera, CarreraRepository> implements ICarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContains(String nombre) {
        return repository.findCarreraByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreIgnoreCase(String nombre) {
        return repository.findCarreraByNombreIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByCantAniosAfter(Integer cantAnios) {
        return repository.findCarreraByCantAniosAfter(cantAnios);
    }
}
