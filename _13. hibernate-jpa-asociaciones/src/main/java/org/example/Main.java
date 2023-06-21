package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n\n------------------ | ----------------");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente c = new Cliente();
            c.setNombre("Cata");
            c.setApellido("Edu");
            c.setFormapago("credito");
            em.persist(c);

            Factura f = new Factura();
            f.setDescripcion("compras oficina");
            f.setTotal(1000L);
            em.persist(f);

            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }

    }



}