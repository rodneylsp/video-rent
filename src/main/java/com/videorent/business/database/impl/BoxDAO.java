package com.videorent.business.database.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.GenericDAO;
import com.videorent.business.model.Box;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class BoxDAO extends GenericDAO<Box> implements DAO<Box> {

    private static final Logger logger = LogManager.getLogger(BoxDAO.class);

    @Inject
    public BoxDAO(final EntityManager entityManager1){
        logger.debug("Instanciando {}",BoxDAO.class.getName());
        entityManager = entityManager1;
        setClass(Box.class);
    }
}
