package com.videorent.business.database.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.GenericDAO;
import com.videorent.business.model.Filme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FilmeDAO extends GenericDAO<Filme> implements DAO<Filme> {

    private static final Logger logger = LogManager.getLogger(FilmeDAO.class);

    @Inject
    public FilmeDAO(final EntityManager entityManager1){
        logger.debug("Instanciando {}",FilmeDAO.class.getName());
        entityManager = entityManager1;
        setClass(Filme.class);
    }


}
