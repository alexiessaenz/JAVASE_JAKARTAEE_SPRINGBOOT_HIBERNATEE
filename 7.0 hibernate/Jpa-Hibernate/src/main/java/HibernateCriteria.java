import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.criteria.*;
import org.tbsJunit.jpaHib.entity.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

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

        System.out.println("================ listar where equals =========");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre");

        query.select(from).where(criteria.equal(from.get("nombre"), nombreParam));
        clientes = em.createQuery(query).setParameter("nombre", "Andres").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("====================usando where like para buscar clientes por nombre ========");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParameLike = criteria.parameter(String.class, "nombreParam");
        query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParameLike)));
        clientes = em.createQuery(query).setParameter("nombreParam", "%jo%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("==================== ejemplo usando where between para rangos===============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.between(from.get("id"),2L, 10L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=================== consulta where in ==============");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<List> listParam = criteria.parameter(List.class, "nombres");
        query.select(from).where(from.get("nombre").in(listParam));
        clientes = em.createQuery(query)
                .setParameter("nombres", Arrays.asList("Andres", "John", "Charly"))
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=================== filtrar usando predicados mayor que o mayor o igual que ==============");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class):
        query.select(from).where(criteria.gt(from.get("id"), 2L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.ge(criteria.length(from.get("nombre")),6L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=================== consulta con los predicados conjuncion and y or ==============");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        Predicate porNombre = criteria.equal(from.get("nombre"),"Andres");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"),"debito");
        Predicate p3 = criteria.ge(from.get("id"),4L);
        query.select(from).where(criteria.and(p3,criteria.or(porNombre, porFormaPago)));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        
    }
}
