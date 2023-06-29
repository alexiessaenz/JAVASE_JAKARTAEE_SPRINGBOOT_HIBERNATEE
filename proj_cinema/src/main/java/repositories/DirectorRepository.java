package repositories;

import entities.Director;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class DirectorRepository implements CrudRepository<Director>{
    private EntityManager em;
    private Director peli;

    @Override
    public List<Director> listar(){
        em = JpaUtil.getEntityManager();
        List<Director> directors = em.createQuery("select e from Director e",
                Director.class).getResultList();
        em.close();
        return directors;

    }

    @Override
    public Director porId(Long id ){
        em = JpaUtil.getEntityManager();
        peli = em.find(Director.class,id);
        em.close();
        return peli;
    }

    @Override
    public void editar(Director director) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(director);
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
    public void crear(Director director)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //Director director = em.find(Director.class, id);
            em.getTransaction().begin();
            em.persist(director);
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
            Director director = em.find(Director.class, id);
            em.getTransaction().begin();
            em.remove(director);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
