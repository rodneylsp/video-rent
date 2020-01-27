package com.videorent.business.service.impl;

import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements IClienteService {

    private static List<Cliente> clientesDB = new ArrayList<>();

    @Override
    public void inserir(Cliente cliente) {
        clientesDB.add(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clientesDB;
    }


}
