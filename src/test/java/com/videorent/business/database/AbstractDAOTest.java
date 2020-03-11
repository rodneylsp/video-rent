package com.videorent.business.database;

import com.videorent.business.database.config.JPAUtil;
import com.videorent.business.model.AbstractEntity;
import org.junit.Before;

import javax.persistence.EntityManager;

public abstract class AbstractDAOTest<T extends AbstractEntity> {

    protected static EntityManager entityManager;
    protected DAO<T> dao;

    protected void init(){
        entityManager = JPAUtil.getEntityManager();
    }

}
