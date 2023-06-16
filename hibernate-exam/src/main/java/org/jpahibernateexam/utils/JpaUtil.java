package org.jpahibernateexam.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private  static final EntityManagerFactory entityManagerFactory =
            buildEntityMAnagerFactor();

    private static EntityManagerFactory buildEntityMAnagerFactor(){
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}

