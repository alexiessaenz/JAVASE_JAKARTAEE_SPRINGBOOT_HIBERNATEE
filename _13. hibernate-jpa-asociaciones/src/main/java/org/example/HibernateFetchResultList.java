package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Alumno;
import org.example.entities.Cliente;
import org.example.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        List<Cliente> clientes= em.createQuery("select distinct c from Cliente c left outer join fetch c.direcciones" +
                        " left outer join fetch c.clienteDetalle", Cliente.class)
                .setParameter("id",1L).getResultList();
        clientes.forEach(cliente -> System.out.println(
                cliente.getNombre() + ", direcciones: " + cliente.getDirecciones()
        ));
        em.close();
    }
}
