import jakarta.persistence.EntityManager;
import services.PeliculaServiceImpl;
import utils.JpaUtil;

public class listarpelis {
    public static void main(String[] args) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        PeliculaServiceImpl ps = new PeliculaServiceImpl(em);
        var pelis= ps.listar();

        pelis.forEach(peli -> System.out.println(
                peli.getTitulo() + ", " + peli.getDirector()
        ));
    }
}
