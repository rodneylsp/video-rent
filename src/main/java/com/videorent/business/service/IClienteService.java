package com.videorent.business.service;

import com.videorent.business.model.Cliente;

import java.util.List;

public interface IClienteService {

    void inserir(Cliente cliente);

    List<Cliente> findAll();
}
