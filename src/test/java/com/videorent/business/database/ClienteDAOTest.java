package com.videorent.business.database;

import com.videorent.business.database.config.JPAUtil;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClienteDAOTest {

    @PersistenceContext
    private static EntityManager entityManager;

    @Inject
    private DAO<Cliente> dao;

    @Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Rodney Luiz da Silva Pereira");

        dao.insert(cliente);

        Cliente clienteEncontrado = dao.findById(2L);

        Assert.assertNotNull(clienteEncontrado);
        Assert.assertEquals("Rodney", clienteEncontrado.getNome());
    }
}
