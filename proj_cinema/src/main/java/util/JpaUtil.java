package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private  static final EntityManagerFactory entityManagerFactory =
            buildEntityMAnagerFactor();

    private static EntityManagerFactory buildEntityMAnagerFactor(){
        return Persistence.createEntityManagerFactory("cine");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
