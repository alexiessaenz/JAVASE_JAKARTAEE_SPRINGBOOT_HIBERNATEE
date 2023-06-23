package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

public class HibernateAsociacionesManyToOneFind{
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class,5L);
//            Factura factura = Factura.builder()
//
//                    .build();
            System.out.println(cliente);
        }catch(Exception e){

        }finally {

        }
    }
}
