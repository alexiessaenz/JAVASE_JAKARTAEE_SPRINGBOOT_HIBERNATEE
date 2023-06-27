package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.ClienteDetalle;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

public class AsociacionOneToOne {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = Cliente.builder()
                    .nombre("Cata")
                    .apellido("Edu")
                    .formapago("paypal")
                    .build();


            em.persist(cliente);

            ClienteDetalle cd = ClienteDetalle.builder()
                    .prime(true)
                    .puntosAcumulados(4321L)
                    .build();
            em.persist(cd);
//            cliente.setDetalle(detalle);
            cliente.addDetalle(cd);

            em.getTransaction().commit();
            System.out.println(cliente);


        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
