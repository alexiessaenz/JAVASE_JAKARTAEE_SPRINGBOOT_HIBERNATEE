package repositories;

import jakarta.persistence.EntityManager;
import org.jpahibernateexam.entities.Empleado;
import org.jpahibernateexam.utils.JpaUtil;

import java.util.List;

public class PeliculaRepository implements CrudRepository{
    private EntityManager em;
    private Empleado emp;

    @Override
    public List<Empleado> listar(){
        em = JpaUtil.getEntityManager();
        List<Empleado> empleados = em.createQuery("select e from Empleado e",
                Empleado.class).getResultList();
        em.close();
        return empleados;

    }

    @Override
    public Empleado porId(Long id ){
        em = JpaUtil.getEntityManager();
        emp = em.find(Empleado.class,id);
        em.close();
        return emp;
    }

    @Override
    public void editar(Empleado empleado) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(empleado);
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
    public void crear(Empleado empleado)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //Empleado empleado = em.find(Empleado.class, id);
            em.getTransaction().begin();
            em.persist(empleado);
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
            Empleado empleado = em.find(Empleado.class, id);
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
