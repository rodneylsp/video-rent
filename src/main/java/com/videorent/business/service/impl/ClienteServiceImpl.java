package com.videorent.business.service.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.database.util.JPAUtil;
import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ClienteServiceImpl implements IClienteService {

    private static Logger logger = LogManager.getLogger(ClienteServiceImpl.class);
    private static DAO<Cliente> dao;

    @Inject
    public ClienteServiceImpl(DAO<Cliente> clienteDAO){
        logger.debug("Instanciando {}", ClienteServiceImpl.class.getName());
        dao = clienteDAO;
    }

    @Override
    public void inserir(Cliente cliente) throws BusinessException {

        logger.debug("inserindo cliente");
        if(cliente == null){
            throw new IllegalArgumentException("Parametro invalido.");
        }

        if(cliente.getNome().length() < 20){
            throw new BusinessException("Nome invalido");
        }
        dao.insert(cliente);

        logger.debug("Cliente inserido");
    }

    @Override
    public List<Cliente> findAll() {
        return dao.findAll();
    }


}
