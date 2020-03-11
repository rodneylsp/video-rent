package com.videorent.business.service;

import com.videorent.business.model.Aluguel;
import com.videorent.exception.BusinessException;

public interface IAluguelService {

    public void inserir(Aluguel aluguel) throws BusinessException;
}
