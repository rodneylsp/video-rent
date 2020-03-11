package com.videorent.business.database;

import com.videorent.business.database.impl.AluguelDAO;
import com.videorent.business.database.impl.BoxDAO;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Aluguel;
import com.videorent.business.model.Box;
import com.videorent.business.model.Cliente;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

public class AluguelDAOTest extends AbstractDAOTest<Aluguel>{

    //@Test
    public void deveInserirAluguelNoBancoDeDados(){

        Aluguel aluguelParaCadastrar = initAluguel();

        dao = new AluguelDAO(entityManager);
        dao.insert(aluguelParaCadastrar);

        Aluguel aluguelCadastrado = dao.findById(1L);
        assertNotNull(aluguelCadastrado);
        assertEquals(new Long(1), aluguelCadastrado.getId());
        assertEquals(new Double(11.5), aluguelCadastrado.getTotal());

//        dao.remove(aluguelCadastrado);
//        aluguelCadastrado = dao.findById(1L);
//        assertNull(aluguelCadastrado);
    }


    private Aluguel initAluguel(){

        DAO<Cliente> daoCliente = new ClienteDAO(entityManager);
        Cliente clienteCadastrado = daoCliente.findById(10L); //valor cadastrado no dataset

        DAO<Box> daoBox = new BoxDAO(entityManager);
        Box boxCadastrado = daoBox.findById(10L); //valor cadastrado no dataset

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(clienteCadastrado);
        aluguel.setData(new Date());
        aluguel.setBoxes(new HashSet<>());
        aluguel.getBoxes().add(boxCadastrado);
        aluguel.setTotal(11.5);
        return aluguel;
    }
}
