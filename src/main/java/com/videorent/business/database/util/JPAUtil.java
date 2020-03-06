package com.videorent.business.database.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("pu01");
    }

    private JPAUtil(){}

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        factory.close();
    }

}
