package com.videorent.business.database.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.GenericDAO;
import com.videorent.business.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO extends GenericDAO implements DAO<Cliente> {

    private static final Logger logger = LogManager.getLogger(ClienteDAO.class);

    @Inject
    public ClienteDAO(final EntityManager entityManager1){
        logger.debug("Instanciando {}",ClienteDAO.class.getName());
        entityManager = entityManager1;
    }

    @Override
    public void insert(Cliente entity) {
        logger.debug("Inserindo cliente {}", entity);


        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    @Override
    public Cliente findById(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> findAll() {
        Query query = entityManager.createQuery("select c from Cliente c");
        return (List<Cliente>) query.getResultList();
    }

    @Override
    public void remove(Cliente entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Cliente clienteARemover = entityManager.find(Cliente.class, entity.getId());
        entityManager.remove(clienteARemover);
        tx.commit();
    }

    @Override
    public Cliente update(Cliente entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Cliente clienteAtualizado = entityManager.merge(entity);
        tx.commit();
        return clienteAtualizado;
    }
}
