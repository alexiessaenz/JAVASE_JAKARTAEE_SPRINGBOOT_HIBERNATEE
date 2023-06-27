package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.entities.Direccion;
import org.example.util.JpaUtil;

public class AsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre("Cata");
            cliente.setApellido("Edu");
            cliente.setFormapago("Mercado pago");

            Direccion dir1 =
            Direccion.builder()
                    .calle("El Verge")
                    .numero(123)
                    .build();

            Direccion dir2 =
                    Direccion.builder()
                            .calle("Vasco de Gama")
                            .numero(456)
                            .build();
            cliente.getDirecciones().add(dir1);
            cliente.getDirecciones().add(dir2);
            em.persist(cliente);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }
    }
}
