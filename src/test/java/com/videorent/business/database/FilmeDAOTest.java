package com.videorent.business.database;

import com.videorent.business.database.impl.FilmeDAO;
import com.videorent.business.model.Filme;
import com.videorent.business.model.enums.GeneroEnum;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FilmeDAOTest extends AbstractDAOTest<Filme> {

    @Test
    public void deveInserirFilmeNoBancoDeDados(){

        Filme filme = new Filme();
        filme.setTitulo("Maquina Mortifera");
        filme.setAno(1986);
        filme.setGenero(GeneroEnum.ACAO);

        dao = new FilmeDAO(entityManager);
        dao.insert(filme);

        Filme filmeEncontrado = dao.findById(3L);
        assertNotNull(filmeEncontrado);
        assertEquals("Maquina Mortifera", filmeEncontrado.getTitulo());

//        List<Filme> clientes = dao.findAll();
//        assertEquals(3, clientes.size());
//        assertEquals(new Long(1), clientes.get(0).getId());
//        assertEquals(new Long(10), clientes.get(1).getId());


//        dao.remove(filmeEncontrado);
//        filmeEncontrado = dao.findById(1L);
//        assertNull(filmeEncontrado);
    }

}
