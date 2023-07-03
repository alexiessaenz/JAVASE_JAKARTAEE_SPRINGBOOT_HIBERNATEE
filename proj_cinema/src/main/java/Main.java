import entities.GanaPremio;
import entities.Genero;
import entities.Pelicula;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Pelicula p = new Pelicula();
          String s =  p.getClass().getName();
//        ServiceImpl ps = new <Pelicula>ServiceImpl();
//        List<Pelicula> listar = ps.listar();
//        listar.forEach(System.out::println);



        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("\n\n\n------------------ | ----------------");

        try {
            em.getTransaction().begin();
            Genero c = new Genero();
            c.setNombre("Cata");;
            em.persist(c);

            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }
    }
}