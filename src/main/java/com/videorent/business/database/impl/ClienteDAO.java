package com.videorent.business.database.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.GenericDAO;
import com.videorent.business.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente> implements DAO<Cliente> {

    private static final Logger logger = LogManager.getLogger(ClienteDAO.class);

    @Inject
    public ClienteDAO(final EntityManager entityManager1){
        logger.debug("Instanciando {}",ClienteDAO.class.getName());
        entityManager = entityManager1;
        setClass(Cliente.class);
    }

}
