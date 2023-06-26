package org.tbsJunit.jpaHib;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernateSingleResultWhere {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query =em.createQuery("select c from Cliente c where c.formapago=?1", Cliente.class);
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        //List<Cliente> clientes = query.getResultList();
        System.out.println(c);
        em.close();
    }
}