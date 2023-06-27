package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.ClienteDetalle;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

public class OneToOneBidireccional {
    public static void main(String[] args) {

        System.out.println("\n\n\n------------------ | ----------------");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente c = new Cliente();
            c.setNombre("Cata");
            c.setApellido("Edu");
            c.setFormapago("credito");


            ClienteDetalle cd = new ClienteDetalle();
            cd.setPrime(true);
            cd.setPuntosAcumulados(8000L);
            c.addDetalle(cd);
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
