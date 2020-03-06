package com.videorent.business.database;

import com.videorent.business.model.AbstractEntity;

public interface DAO<T extends AbstractEntity> {

    void insert(T entity);
    T findById(Long id);
    void remove(T entity);
    T update(T entity);
}
