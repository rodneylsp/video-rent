package com.videorent.business.database.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.GenericDAO;
import com.videorent.business.model.Aluguel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AluguelDAO extends GenericDAO<Aluguel> implements DAO<Aluguel> {

    private static final Logger logger = LogManager.getLogger(AluguelDAO.class);

    @Inject
    public AluguelDAO(final EntityManager entityManager1){
        logger.debug("Instanciando {}",AluguelDAO.class.getName());
        entityManager = entityManager1;
        setClass(Aluguel.class);
    }
}
