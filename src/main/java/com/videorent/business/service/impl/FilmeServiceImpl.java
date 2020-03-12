package com.videorent.business.service.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Box;
import com.videorent.business.model.Filme;
import com.videorent.business.service.IFilmeService;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FilmeServiceImpl implements IFilmeService {

    private static Logger logger = LogManager.getLogger(FilmeServiceImpl.class);
    private DAO<Filme> dao;

    public void inserir(Filme filme) {
        dao.insert(filme);
    }

    @Override
    public Filme atualizar(Filme filme) throws BusinessException {
        return dao.update(filme);
    }

    @Override
    public void remover(Long id) throws BusinessException {
        dao.remove(dao.findById(id));
    }

    @Override
    public List<Filme> findAll() {
        return dao.findAll();
    }

    @Override
    public Filme findById(Long id) {
        return dao.findById(id);
    }

}
