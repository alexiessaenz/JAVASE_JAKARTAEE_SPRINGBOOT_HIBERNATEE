package org.tbsJunit.jpaHib;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManager;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import java.util.List;


public class HibernateListar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c",
                Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();

    }
}
