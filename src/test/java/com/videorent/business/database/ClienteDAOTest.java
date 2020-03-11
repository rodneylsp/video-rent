package com.videorent.business.database;

import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteDAOTest extends AbstractDAOTest<Cliente>{

    @Before
    public void init(){
        super.init();
        dao = new ClienteDAO(entityManager);
    }

    @After
    public void destroy(){
        entityManager.close();
    }

    @Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setNome("Rodney Luiz da Silva Pereira");

        dao.insert(cliente);
        Cliente clienteEncontrado = dao.findById(3L);

        assertNotNull(clienteEncontrado);
        assertEquals("Rodney Luiz da Silva Pereira", clienteEncontrado.getNome());
    }

    @Test
    public void findAllTest(){

        Cliente cliente = new Cliente();
        cliente.setNome("Rodney");
        dao.insert(cliente);

        cliente = new Cliente();
        cliente.setNome("Jose");
        dao.insert(cliente);

        List<Cliente> clientes = dao.findAll();
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
    }

}
