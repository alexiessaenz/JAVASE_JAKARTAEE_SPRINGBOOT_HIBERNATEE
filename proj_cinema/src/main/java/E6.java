import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;

import java.util.List;

public class E6 {
    public static void main(String[] args) {
        //6.	¿Qué empresa es la distribuidora de la película ‘Casablanca’?

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo = 'Casablanca'");
        List<Pelicula> peliculaList = query.getResultList();
        peliculaList.forEach(pelicula -> System.out.println(
                pelicula.getDistribuidora()
        ));
    }
}
