package com.videorent.business.service;

import com.videorent.business.model.Cliente;
import com.videorent.exception.BusinessException;

import java.util.List;

public interface IClienteService {

    void inserir(Cliente cliente) throws BusinessException;

    List<Cliente> findAll();
}
