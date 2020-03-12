package com.videorent.business.service;

import com.videorent.business.model.Filme;
import com.videorent.exception.BusinessException;

import java.util.List;

public interface IFilmeService {

    void inserir(Filme filme) throws BusinessException;

    Filme atualizar(Filme filme) throws BusinessException;

    void remover(Long id) throws BusinessException;

    List<Filme> findAll();

    Filme findById(Long id);
}
