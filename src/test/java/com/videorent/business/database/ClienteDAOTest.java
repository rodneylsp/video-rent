package com.videorent.business.database;

import com.videorent.business.database.config.JPAUtil;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteDAOTest {

    private static EntityManager entityManager;
    private DAO<Cliente> dao;

    @Before
    public void init(){
        entityManager = JPAUtil.getEntityManager();
        dao = new ClienteDAO(entityManager);
    }

    @After
    public void destroy(){
        entityManager.close();
    }

    @Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setId(3L);
        cliente.setNome("Rodney Luiz da Silva Pereira");

        dao.insert(cliente);
        Cliente clienteEncontrado = dao.findById(3L);

        assertNotNull(clienteEncontrado);
        assertEquals("Rodney Luiz da Silva Pereira", clienteEncontrado.getNome());
    }

    @Test
    public void findAllTest(){

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Rodney");
        dao.insert(cliente);

        cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Jose");
        dao.insert(cliente);

        List<Cliente> clientes = dao.findAll();
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
    }

}
