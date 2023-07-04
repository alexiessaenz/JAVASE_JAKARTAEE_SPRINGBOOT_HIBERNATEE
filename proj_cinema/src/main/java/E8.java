import entities.Actor;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;

import java.util.List;

public class E8 {
    public static void main(String[] args) {
        //6.	¿Qué empresa es la distribuidora de la película ‘Casablanca’?

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery(
                "SELECT p.nacionalidad, SUM(p.taquilla) from Pelicula p WHERE p.nacionalidad = 'España'"
        );
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            String nacionalidad = (String) result[0];
            double recaudacion = (double) result[1];
            System.out.printf("|%13s|%13s|\n","nacionalidad","recaudacion");
            System.out.println("+-------------+-------------+");
            System.out.printf("|%13s|%13.2f|\n",nacionalidad,recaudacion);

        }
    }
}
