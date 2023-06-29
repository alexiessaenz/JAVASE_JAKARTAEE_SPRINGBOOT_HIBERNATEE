import entities.GanaPremio;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import services.ServiceImpl;
import utils.JpaUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Pelicula p = new Pelicula();

        ServiceImpl ps = new <Pelicula>ServiceImpl();
        List<Pelicula> listar = ps.listar();
        listar.forEach(System.out::println);


    }
}