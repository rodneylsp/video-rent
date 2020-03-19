package com.videorent.business.database;

import com.videorent.business.database.impl.FilmeDAO;
import com.videorent.business.model.Filme;
import com.videorent.business.model.enums.GeneroEnum;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FilmeDAOTest extends AbstractDAOTest<Filme> {

    @Test
    public void deveEncontrarFilmePeloSeuID(){

        dao = new FilmeDAO(entityManager);
        List<Filme> filmes = dao.findAll();
        assertEquals(2,filmes.size());
    }

    @Test
    public void deveInserirFilmeNoBancoDeDados(){

        Filme filme = new Filme();
        filme.setTitulo("Maquina Mortifera");
        filme.setAno(1986);
        filme.setGenero(GeneroEnum.ACAO);

        dao = new FilmeDAO(entityManager);
        dao.insert(filme);

        Filme filmeEncontrado = dao.findById(filme.getId());
        assertNotNull(filmeEncontrado);
        assertEquals("Maquina Mortifera", filmeEncontrado.getTitulo());
    }

}
