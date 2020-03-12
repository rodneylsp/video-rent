package com.videorent.business.service;

import com.videorent.business.model.Cliente;
import com.videorent.exception.BusinessException;

import java.util.List;

public interface IClienteService {

    void inserir(Cliente cliente) throws BusinessException;

    Cliente atualizar(Cliente cliente) throws BusinessException;

    void remover(Long id) throws BusinessException;

    List<Cliente> findAll();

    Cliente findById(Long id);

}
