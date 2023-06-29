package repositories;

import entities.Actor;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class ActorRepository implements CrudRepository<Actor>{
    private EntityManager em;
    private Actor act;

    @Override
    public List<Actor> listar(){
        em = JpaUtil.getEntityManager();
        List<Actor> actores = em.createQuery("select e from Actor e",
                Actor.class).getResultList();
        em.close();
        return actores;

    }

    @Override
    public Actor porId(Long id ){
        em = JpaUtil.getEntityManager();
        act = em.find(Actor.class,id);
        em.close();
        return act;
    }

    @Override
    public void editar(Actor actor) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(actor);
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
    public void crear(Actor actor)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //Actor actor = em.find(Actor.class, id);
            em.getTransaction().begin();
            em.persist(actor);
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
            Actor actor = em.find(Actor.class, id);
            em.getTransaction().begin();
            em.remove(actor);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
