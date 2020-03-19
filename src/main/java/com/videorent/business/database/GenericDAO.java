package com.videorent.business.database;

import com.videorent.business.model.AbstractEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class GenericDAO<T extends AbstractEntity>{

    private static final Logger logger = LogManager.getLogger(GenericDAO.class);
    protected static EntityManager entityManager;

    private Class<T> tClass;

    public void insert(T entity) {
        logger.debug("Inserindo entidade {}", entity);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
        logger.debug("Entidade inserida {}", entity);
    }


    public T findById(Long id) {
        logger.debug("Buscando entidade por id {}", id);
        T entity = entityManager.find(tClass, id);
        logger.debug("Entidade encontrada {}", entity);
        return entity;
    }


    public List<T> findAll() {
        logger.debug("Buscando todas as entidades.");
        TypedQuery<T> query = entityManager.createQuery("from " + tClass.getName(), tClass);
        return query.getResultList();
    }


    public void remove(T entity) {
        logger.debug("Removendo entidade {}", entity);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T entidadeARemover = entityManager.find(tClass, entity.getId());
        entityManager.remove(entidadeARemover);
        tx.commit();
        logger.debug("Entidade removida {}", entity);
    }


    public T update(T entity) {
        logger.debug("Atualizando entidade {}", entity);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T entidadeAtualizada = entityManager.merge(entity);
        tx.commit();
        logger.debug("Entidade atualizada {}", entity);
        return entidadeAtualizada;
    }

    protected void setClass(Class<T> classToSet){
        this.tClass = classToSet;
    }

}
