import entities.Actor;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import services.ActorServiceImpl;
import services.PeliculaServiceImpl;
import utils.JpaUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsertActor {

//    4.	Inserta tus datos en `actor` e inclúyete entre el reparto de actores de la película ‘Mar Adentro’.
    public static void main(String[] args) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        Actor a = new Actor();
        ActorServiceImpl as = new ActorServiceImpl(em);
        PeliculaServiceImpl ps = new PeliculaServiceImpl(em);
        a.setCodActor(34L);
        a.setNombre("Moises");
        a.setNacionalidad("Salvadorenio");
        a.setFNAcimiento(LocalDate.parse("1993-01-12").atStartOfDay());
        a.setLNacimiento("Bo La Pila, MEanguera, Morazan.");
        as.crear(a);
        Pelicula p = new Pelicula();
        p.setAnyo("2004");
        p.setNacionalidad("España");
        p.setDuracion(105f);
        p.setFechaEstreno(LocalDate.parse("2004-09-03").atStartOfDay());
        p.setTaquilla(21469765.482);
        p.setProductora("SOGECINE");
        p.setDistribuidora("SOGEPAQ S.A.");
        ps.crear(p);
        p= ps.porId(6L);
        p.getActores().add(a);
        p= ps.porId(6L);
        System.out.println(p);

        em.close();

//        ServiceImpl ps = new <Pelicula>ServiceImpl();
//        List<Pelicula> listar = ps.listar();
//        listar.forEach(System.out::println);
    }
}
