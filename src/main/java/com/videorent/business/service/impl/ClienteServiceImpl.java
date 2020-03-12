package com.videorent.business.service.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;
import com.videorent.business.service.validation.ClienteNomeInvalido;
import com.videorent.business.service.validation.Validation;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
public class ClienteServiceImpl implements IClienteService {

    private static Logger logger = LogManager.getLogger(ClienteServiceImpl.class);
    private DAO<Cliente> dao;

    @Inject
    public ClienteServiceImpl(DAO<Cliente> clienteDAO){
        logger.debug("Instanciando {}", ClienteServiceImpl.class.getName());
        dao = clienteDAO;
    }

    @Override
    public void inserir(Cliente cliente) throws BusinessException {

        if(Objects.isNull(cliente)){
            throw new IllegalArgumentException("Parametro invalido");
        }

        logger.debug("Inserindo cliente...");

        List<Validation<Cliente>> regrasDeNegocio = new ArrayList<>();
        regrasDeNegocio.add(new ClienteNomeInvalido());

        for(Validation<Cliente> regra : regrasDeNegocio){
            regra.validate(cliente);
        }

        dao.insert(cliente);

        logger.debug("Cliente inserido.");
    }

    @Override
    public Cliente atualizar(Cliente cliente) throws BusinessException {
        return dao.update(cliente);
    }

    @Override
    public void remover(Long id) throws BusinessException {
         dao.remove(dao.findById(id));
    }

    @Override
    public List<Cliente> findAll() {
        return dao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return dao.findById(id);
    }


}
