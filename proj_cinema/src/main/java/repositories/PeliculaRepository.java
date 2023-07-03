package repositories;

import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import utils.JpaUtil;

import java.util.List;

public class PeliculaRepository implements CrudRepository<Pelicula>{
    private EntityManager em;

    public PeliculaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public List<Pelicula> listar(){
        em = JpaUtil.getEntityManager();
        List<Pelicula> peliculas = em.createQuery("select e from Pelicula e",
                Pelicula.class).getResultList();
        em.close();
        return peliculas;

    }

    @Override
    @Transactional
    public Pelicula porId(Long id ){
        em = JpaUtil.getEntityManager();
        Pelicula peli = em.find(Pelicula.class, id);
        em.close();
        return peli;
    }

    @Override
    public void editar(Pelicula pelicula) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(pelicula);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void crear(Pelicula pelicula)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //Pelicula pelicula = em.find(Pelicula.class, id);
            em.getTransaction().begin();
            em.persist(pelicula);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }

    }

    @Override
    public void eliminar(long id) throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            Pelicula pelicula = em.find(Pelicula.class, id);
            em.getTransaction().begin();
            em.remove(pelicula);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Pelicula pelicula) throws Exception {

    }

}
