package com.videorent.business.database;

import com.videorent.business.database.config.JPAUtil;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Cliente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;

public class ClienteDAOTest {

    private static EntityManager entityManager;

    @BeforeClass
    public static void init(){
        entityManager = JPAUtil.getEntityManager();
    }

    //@Test
    public void inserirClienteTest(){

        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Rodney");

//        ClienteDAO dao = ClienteDAO.getInstance(entityManager);
//        dao.insert(cliente);
//
//        Cliente clienteEncontrado = dao.findById(2L);
//
//        Assert.assertNotNull(clienteEncontrado);
//        Assert.assertEquals("Rodney", clienteEncontrado.getNome());
    }
}
