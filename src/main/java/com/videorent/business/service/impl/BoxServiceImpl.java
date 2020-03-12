package com.videorent.business.service.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Box;
import com.videorent.business.service.IBoxService;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BoxServiceImpl implements IBoxService {

    private static Logger logger = LogManager.getLogger(BoxServiceImpl.class);
    private DAO<Box> dao;

    @Override
    public void inserir(Box box) {
        dao.insert(box);
    }

    @Override
    public Box atualizar(Box box) throws BusinessException {
        return dao.update(box);
    }

    @Override
    public void remover(Long id) throws BusinessException {
        dao.remove(dao.findById(id));
    }

    @Override
    public List<Box> findAll() {
        return dao.findAll();
    }

    @Override
    public Box findById(Long id) {
        return dao.findById(id);
    }
}
