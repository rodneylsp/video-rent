package com.videorent.business.service;

import com.videorent.business.model.Aluguel;
import com.videorent.exception.BusinessException;

import java.util.List;

public interface IAluguelService {

    void inserir(Aluguel aluguel) throws BusinessException;

    Aluguel atualizar(Aluguel aluguel) throws BusinessException;

    void remover(Long id) throws BusinessException;

    List<Aluguel> findAll();

    Aluguel findById(Long id);
}
