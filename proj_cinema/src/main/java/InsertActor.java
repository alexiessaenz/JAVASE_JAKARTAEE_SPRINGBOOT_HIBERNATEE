import entities.Actor;
import entities.Pelicula;
import services.ActorServiceImpl;
import services.PeliculaServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsertActor {
    public static void main(String[] args) throws Exception {
        Actor a = new Actor();
        ActorServiceImpl as = new ActorServiceImpl();
        PeliculaServiceImpl ps = new PeliculaServiceImpl();
        a.setCodActor(34L);
        a.setNombre("Moises");
        a.setNacionalidad("Salvadorenio");
        a.setFNAcimiento(LocalDate.parse("1993-01-12").atStartOfDay());
        a.setLNacimiento("Bo La Pila, MEanguera, Morazan.");
        as.crear(a);
        Pelicula p ;
        p= ps.porId(6L);
        System.out.println(p);
        p.getActores().add(a);

//        ServiceImpl ps = new <Pelicula>ServiceImpl();
//        List<Pelicula> listar = ps.listar();
//        listar.forEach(System.out::println);
    }
}
