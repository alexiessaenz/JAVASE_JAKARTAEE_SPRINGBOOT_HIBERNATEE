package org.tbsJunit.jpaHib;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import java.util.List;


public class HibernateListar {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso");
//        EntityManager em = emf.createEntityManager();
        EntityManager em = JpaUtil.getEntityManager();

        List<Cliente> clientes = em.createQuery("select c from Cliente c",
                                 Cliente.class).getResultList();
//        em.
//        Cliente c = new Cliente(null,"moi","saenz","credito");
//        if (em.find(Cliente.class, moi) == c.getNombre()) {
//            em.getTransaction().begin();
//            em.persist(c);
//            em.getTransaction().commit();
//        }
        clientes.forEach(System.out::println);
        em.close();

    }
}
