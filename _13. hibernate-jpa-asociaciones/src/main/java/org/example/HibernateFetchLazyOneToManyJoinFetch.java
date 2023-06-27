package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Cliente c = em.createQuery("select c from Cliente c left outer join fetch " +
                "c.direcciones left join fetch c.clienteDetalle where c.id = :id", Cliente.class)
                .setParameter("id",1L)
                .getSingleResult();
        System.out.println(c.getNombre() + ", " + "direcciones" + c.getDirecciones());
        System.out.println(c.getNombre() + ", " + "detalle: " + c.getClienteDetalle());

        em.close();
    }
}
