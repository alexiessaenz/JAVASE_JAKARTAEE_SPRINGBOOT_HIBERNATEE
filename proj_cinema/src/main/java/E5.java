import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;

import java.util.List;

public class E5 {
    public static void main(String[] args) {
        //6.	¿Qué empresa es la distribuidora de la película ‘Casablanca’?

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery(
                "SELECT p.titulo, p.nacionalidad, p.taquilla*0.8 from Pelicula p WHERE p.nacionalidad = 'Estados Unidos'"
        );
        List<Object[]> results = query.getResultList();
        System.out.printf("|%24s|%14s|%13s|\n","titulo","nacionalidad","recaudacion");
        for (Object[] result : results) {
            String titulo = (String) result[0];
            String nacionalidad = (String) result[1];
            double taquillaeuros = (double) result[2];

            System.out.println("+------------------------+--------------+-------------+");
            System.out.printf("|%24s|%14s|%13.2f|\n",titulo,nacionalidad,taquillaeuros);

        }
    }
}
