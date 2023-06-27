package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

public class OneToManyBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

//        try {
//            em.getTransaction().begin();
//
//            Cliente cliente = Cliente.builder()
//                    .nombre("Cata")
//                    .apellido("Edu")
//                    .formapago("paypal")
//                    .build();
//
//            Factura f1 = Factura.builder()
//                    .descripcion("compras supermercado")
//                    .total(5000L)
//                    .build();
//            Factura f2 = Factura.builder()
//                    .descripcion("compras tecnologia")
//                    .total(7000L)
//                    .build();
//
//            cliente.getFacturas().add(f1);
//
//            em.persist(cliente);
//            em.getTransaction().commit();
//            System.out.println(cliente);
//
//            em.getTransaction().begin();
//            Factura f3 = Factura.builder()
//                    .id(1L)
//                    .descripcion("compras supermercado")
//                    .total(5000L)
//                    .build();
//
//            cliente.getFacturas().remove(f3);
//            em.getTransaction().commit();
//            System.out.println(cliente);
//        }catch (Exception e){
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
    }
}
