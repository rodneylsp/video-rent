package com.videorent.business.service;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Cliente;
import com.videorent.business.service.impl.ClienteServiceImpl;
import com.videorent.exception.BusinessException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ClienteServiceTest {

    private IClienteService servico;

    @Mock
    private DAO<Cliente> dao;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        servico = new ClienteServiceImpl(dao);
    }

    @Test
    public void inserirClienteTest() throws BusinessException {

        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Rodney Luiz da Silva Pereira");

        servico.inserir(cliente);
        Mockito.verify(dao, Mockito.times(1)).insert(cliente);
    }

    @Test(expected = BusinessException.class)
    public void inserirClienteComErroTest() throws BusinessException {

        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Rodney");

        servico.inserir(cliente);
        Mockito.verify(dao, Mockito.times(0)).insert(cliente);
    }

}
