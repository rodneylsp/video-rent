package com.videorent.business.database;

import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteDAOTest extends AbstractDAOTest<Cliente>{


    @Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setNome("Rodney Luiz da Silva Pereira");

        dao = new ClienteDAO(entityManager);
        dao.insert(cliente);

        Cliente clienteEncontrado = dao.findById(cliente.getId());
        assertNotNull(clienteEncontrado);
        assertEquals("Rodney Luiz da Silva Pereira", clienteEncontrado.getNome());
    }

    @Test
    public void findAllTest(){

        dao = new ClienteDAO(entityManager);
        List<Cliente> clientes = dao.findAll();
        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

}
