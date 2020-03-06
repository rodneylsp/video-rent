package com.videorent.business.database;

import com.videorent.business.model.AbstractEntity;

import java.util.List;

public interface DAO<T extends AbstractEntity> {

    void insert(T entity);
    T findById(Long id);
    List<T> findAll();
    void remove(T entity);
    T update(T entity);
}
