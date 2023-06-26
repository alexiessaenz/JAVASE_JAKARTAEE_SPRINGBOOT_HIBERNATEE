package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.ClienteDetalle;
import org.example.util.JpaUtil;

public class OneToOneBidireccionalFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, 2L);


            ClienteDetalle cd = new ClienteDetalle();
            cd.setPrime(true);
            cd.setPuntosAcumulados(8000L);
            c.setClienteDetalle(cd);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println(c);
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }
    }
}
