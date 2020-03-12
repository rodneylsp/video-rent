package com.videorent.business.service;

import com.videorent.business.model.Box;
import com.videorent.exception.BusinessException;

import java.util.List;

public interface IBoxService {

    void inserir(Box box) throws BusinessException;

    Box atualizar(Box box) throws BusinessException;

    void remover(Long id) throws BusinessException;

    List<Box> findAll();

    Box findById(Long id);
}
