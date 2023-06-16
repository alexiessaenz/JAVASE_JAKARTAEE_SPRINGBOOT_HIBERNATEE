package org.tbsJunit.jpaHib.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.tbsJunit.jpaHib.entities.Cliente;

import java.util.Arrays;
import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = em.getCriteriaBuilder();

        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);


        Root<Cliente> from = query.from(Cliente.class);

        query.select(from);
        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);
        System.out.println("============== listar where equals =============");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre");

        query.select(from).where(criteria.equal(from.get("nombre"), nombreParam));
        clientes = em.createQuery(query).setParameter("nombre","moi").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============================== usando where like para buscar clientes por nombre ===========================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParamLike = criteria.parameter(String.class, "nombreParam");
        query.select(from).where(
                criteria.like( criteria.upper(from.get("nombre")),
                criteria.upper(nombreParamLike))
        );
        clientes = em.createQuery(query).setParameter("nombreParam","%oi%").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============================== ejemplo usando where between para rangos ===========================");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.between(from.get("id"), 2L, 6L));
        clientes  = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============================== consulta where in ===========================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        ParameterExpression<List> listParam = criteria.parameter(List.class,"nombres");
        query.select(from).where(from.get("nombre").in(listParam));

        clientes = em.createQuery(query)
                        .setParameter("nombres", Arrays.asList("moi","Jhon","Lou"))
                                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============================== consulta where in ===========================");

    }
}
