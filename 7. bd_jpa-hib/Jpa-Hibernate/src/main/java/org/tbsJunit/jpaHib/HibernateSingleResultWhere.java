package org.tbsJunit.jpaHib;

import jakarta.persistence.Entity;
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
        Query query = em.createQuery("select c from Cliente c where c.formapago=?1 and nombre=?2", Cliente.class);
        System.out.println("ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1,pago);
        query.setParameter(2,"Franchezco");
        query.setMaxResults(1);
        Cliente clientes = (Cliente) query.getSingleResult();
        System.out.println(clientes);
        em.close();
    }
}
