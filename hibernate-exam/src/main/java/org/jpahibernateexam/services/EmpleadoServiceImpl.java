package org.jpahibernateexam.services;

import jakarta.persistence.EntityManager;
import org.jpahibernateexam.entities.Empleado;
import org.jpahibernateexam.repositories.EmpleadoRepository;

import javax.swing.*;
import java.util.List;

public class EmpleadoServiceImpl implements IEmpleadoService, EmpleadoRepository {
    private EntityManager em;
    private Empleado emp;


    public EmpleadoServiceImpl(EntityManager em) {
        this.em = em;

    }

    @Override
    public List<Empleado> listar() {
        List<Empleado> empleadoFound = em.createQuery("select e from Empleado e",
                Empleado.class).getResultList();
        em.close();
        return empleadoFound;
    }

    @Override
    public Empleado porId(Long id) {
        emp = em.find(Empleado.class, id);
       // em.close();
        return emp;

    }

    @Override
    public void crear(Empleado empleado) {
        try{
            em.persist(empleado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    @Override
    public void eliminar(long id) {
        try {
            emp = em.find(Empleado.class, id);
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Empleado empleado) {
        try{
            em.getTransaction().begin();
            em.merge(empleado);
            em.getTransaction().commit();
            System.out.println(empleado);
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
