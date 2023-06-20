package org.tbsJunit.jpaHib;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.tbsJunit.jpaHib.Exceptions.EmptyFieldException;
import org.tbsJunit.jpaHib.entities.Cliente;
import org.tbsJunit.jpaHib.util.JpaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCriteriaBusquedaDinamica {
    public static void main(String[] args) throws EmptyFieldException {
        Scanner s = new Scanner(System.in);

        System.out.println("Filtro para nombre: ");
        String nombre = s.nextLine();

        System.out.println("Filtro para apellido: ");
        String apellido = s.nextLine();

        System.out.println("Filtro para forma de pago: ");
        String formaPAgo = s.nextLine();
        EntityManager em = JpaUtil.getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
            Root<Cliente> from = query.from(Cliente.class);

            List<Predicate> condiciones = new ArrayList<>();

            if (nombre != null && !nombre.isEmpty()) {
                condiciones.add(cb.equal(from.get("nombre"),nombre));
            }else
                throw new EmptyFieldException("Error en los campos nombre");

            if (apellido != null && !apellido.isEmpty()) {
                condiciones.add(cb.equal(from.get("apellido"),apellido));
            }else
                throw new EmptyFieldException("Error en los campos apellido");

            if (formaPAgo != null && !formaPAgo.isEmpty()) {
                condiciones.add(cb.equal(from.get("formapago"),formaPAgo));
            }else {
                throw new EmptyFieldException("Error en los campos forma pago");
            }
            query.select(from).where(
                    cb.and(
                            condiciones.toArray(
                                    new Predicate[condiciones.size()]
                            )
                    )
            );

            List<Cliente> clientes = em.createQuery(query).getResultList();
            clientes.forEach(System.out::println);
        }catch (EmptyFieldException e){
            e.printStackTrace();
            throw new EmptyFieldException(e.getMessage());
        }finally {
        em.close();

        }


    }
}
