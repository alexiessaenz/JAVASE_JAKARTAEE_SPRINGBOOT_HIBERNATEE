package repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import utils.JpaUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class CrudRepositoryImpl<T, ID extends Serializable> implements CrudRepository<T, ID> {
    private EntityManager em;
    private Class<T> type;

    public CrudRepositoryImpl(Class<T> entityClass) {
        this.type = entityClass;
    }

    @Override
    public List<T> listar() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public T porId(Long id ){
        em= JpaUtil.getEntityManager();
        return (T) em.find(type, id);
    }

    @Override
    public void editar(T t) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(t);
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
    public void crear(T t)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //T actor = em.find(T.class, id);
            em.getTransaction().begin();
            em.persist(t);
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
            T t = em.find(type, id);
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(T t) throws Exception {

    }

}
