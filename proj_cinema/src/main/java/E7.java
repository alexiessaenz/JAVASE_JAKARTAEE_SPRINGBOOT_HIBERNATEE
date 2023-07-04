import entities.Actor;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;

import java.util.List;

public class E7 {
    public static void main(String[] args) {
        //6.	¿Qué empresa es la distribuidora de la película ‘Casablanca’?

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery(
                "SELECT a FROM Actor a WHERE a.nacionalidad = 'Suecia' AND a.fMuerte < current_date "
        );
        List<Actor> actors = query.getResultList();
        actors.forEach(actor -> System.out.println(
                actor.getNombre() + " " + actor.getNacionalidad() + " " + actor.getFMuerte()
        ));
    }
}
