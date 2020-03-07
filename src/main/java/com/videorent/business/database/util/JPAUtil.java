package com.videorent.business.database.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("pu01");
    }

    private JPAUtil(){}

    @Produces
    @RequestScoped
    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(@Disposes EntityManager entityManager){
        entityManager.close();
    }

}
