package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Cliente c = em.find(Cliente.class, 1L);
        System.out.println(c.getNombre() + ", "
        + "direcciones");

    }
}
