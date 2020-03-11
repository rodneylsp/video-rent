package com.videorent.business.database;

import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteDAOTest extends AbstractDAOTest<Cliente>{


    @Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setNome("Rodney Luiz da Silva Pereira");

        dao = new ClienteDAO(entityManager);
        dao.insert(cliente);

        Cliente clienteEncontrado = dao.findById(2L);
        assertNotNull(clienteEncontrado);
        assertEquals("Rodney Luiz da Silva Pereira", clienteEncontrado.getNome());

//        List<Cliente> clientes = dao.findAll();
//        assertEquals(2, clientes.size());
//        assertEquals(new Long(1), clientes.get(0).getId());
//        assertEquals(new Long(10), clientes.get(1).getId());

//        dao.remove(clienteEncontrado);
//        clienteEncontrado = dao.findById(1L);
//        assertNull(clienteEncontrado);
    }

    @Test
    public void findAllTest(){

        dao = new ClienteDAO(entityManager);
        List<Cliente> clientes = dao.findAll();
        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

}
