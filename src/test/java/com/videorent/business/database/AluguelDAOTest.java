package com.videorent.business.database;

import com.videorent.business.database.impl.AluguelDAO;
import com.videorent.business.database.impl.ClienteDAO;
import com.videorent.business.model.Aluguel;
import com.videorent.business.model.Box;
import com.videorent.business.model.Cliente;
import com.videorent.business.model.Filme;
import com.videorent.business.model.enums.GeneroEnum;
import org.junit.After;
import org.junit.Before;

import java.util.Date;
import java.util.HashSet;

public class AluguelDAOTest extends AbstractDAOTest<Aluguel>{

    @Before
    public void init(){
        super.init();
        dao = new AluguelDAO(entityManager);
    }

    @After
    public void destroy(){
        entityManager.close();
    }

    public void deveInserirAluguel(){

    }

    private Aluguel initAluguel(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Rodney Luiz da Silva Pereira");

        Filme filme = new Filme();
        filme.setId(1L);
        filme.setTitulo("Matrix");
        filme.setAno(1999);
        filme.setGenero(GeneroEnum.ACAO);

        Box box = new Box();
        box.setId(1L);
        box.setFilme(filme);
        box.setPreco(10.5);

        Aluguel aluguel = new Aluguel();
        aluguel.setId(1L);
        aluguel.setCliente(cliente);
        aluguel.setData(new Date());
        aluguel.setBoxes(new HashSet<>());
        aluguel.getBoxes().add(box);
        aluguel.setTotal(10.5);

        return aluguel;
    }
}
