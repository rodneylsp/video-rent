package com.videorent.business.database;

import com.videorent.business.database.impl.BoxDAO;
import com.videorent.business.database.impl.FilmeDAO;
import com.videorent.business.model.Box;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoxDAOTest extends AbstractDAOTest<Box> {

    @Test
    public void deveinserirBoxNoBancoDeDados(){

        Box box = new Box();
        box.setFilme(new FilmeDAO(entityManager).findById(10L));
        box.setPreco(9.5);

        dao = new BoxDAO(entityManager);
        dao.insert(box);

        Box boxEncontrado = dao.findById(1L);
        assertNotNull(boxEncontrado);
        assertEquals("Matrix", boxEncontrado.getFilme().getTitulo());

    }
}
