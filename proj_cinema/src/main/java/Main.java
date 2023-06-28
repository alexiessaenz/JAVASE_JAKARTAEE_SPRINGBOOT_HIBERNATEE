import entities.Actor;
import entities.Actor1;
import entities.GanaPremio;
import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class Main {
    public static void main(String[] args) {


        System.out.println("\n\n\n------------------ | ----------------");

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            GanaPremio gp = new GanaPremio();
            em.persist(gp);
            em.getTransaction().commit();
//            em.getTransaction().begin();
//
//            Actor actor = new Actor();
//            actor.setNombre("John");
//
//            em.persist(actor);
//
////            Factura f = new Factura();
////            f.setDescripcion("compras oficina");
////            f.setTotal(1000L);
////            f.setCliente(c);
//////            c.addFactura(f);
////            em.persist(f);
//
//            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }
    }
}