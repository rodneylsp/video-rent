package com.videorent.business.database.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("puTeste");
    }

    private JPAUtil(){}

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        factory.close();
    }
}
