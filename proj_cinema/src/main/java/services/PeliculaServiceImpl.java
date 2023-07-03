package services;

import entities.Pelicula;
import jakarta.persistence.EntityManager;
import repositories.PeliculaRepository;
import repositories.PeliculaRepository;

import java.util.List;

public class PeliculaServiceImpl implements IService<Pelicula> {
    PeliculaRepository Repository;
    EntityManager em;
    Pelicula pelicula = new Pelicula();

    public PeliculaServiceImpl(EntityManager em) {
        this.em = em;
        this.Repository = new PeliculaRepository(em);
    }

    @Override
    public List<Pelicula> listar() throws Exception{
        try {
            return Repository.listar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Pelicula porId(Long id) throws Exception{
        try {
            return Repository.porId(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public void crear(Pelicula pelicula) throws Exception{
        Repository.crear(pelicula);
    }
    @Override
    public void eliminar(long id) throws Exception{
            pelicula =  Repository.porId(id);
            if (pelicula == null) throw new Exception("No existe el pelicula con el id " + id);
            Repository.eliminar(id);
    }
    @Override
    public void editar(Pelicula pelicula) throws Exception{
        pelicula =  Repository.porId(pelicula.getCodPelicula());
        if (pelicula == null)
            Repository.crear(pelicula);
        Repository.editar(pelicula);
    }
}
