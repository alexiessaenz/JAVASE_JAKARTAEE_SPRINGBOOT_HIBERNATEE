package org.tbsJunit.jpaHib;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el id: ");
        Long id = sc.nextLong();

        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);
        em.close();
    }
}
