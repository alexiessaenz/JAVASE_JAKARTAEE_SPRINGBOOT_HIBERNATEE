package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.Factura;
import org.example.util.JpaUtil;

public class OneToManyBididireccionalFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

//        try {
//            em.getTransaction().begin();
//            Cliente cliente = em.find(Cliente.class,1L);
//
//            Factura f1 = Factura.builder()
//                    .descripcion("compras de supermercado")
//                    .total(5000L)
//                    .build();
//            Factura f2 = Factura.builder()
//                    .descripcion("compras de tecnologia")
//                    .total(7000L)
//                    .build();
//
////            Cliente.addFactura(f1);
////            Cliente.addFactura(f1);
//
//            em.getTransaction().commit();
//
//            Factura f3 = Factura.builder()
//                    .descripcion("compras de supermercado")
//                    .total(5000L)
//                    .build();
//
//
//        }catch (Exception e){
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
    }
}
