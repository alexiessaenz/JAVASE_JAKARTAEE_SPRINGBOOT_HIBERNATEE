package repositories;

import entities.Pelicula;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class PeliculaRepository extends CrudRepositoryImpl<Pelicula,Long>{
    public PeliculaRepository() {
        super(Pelicula.class);
    }
}