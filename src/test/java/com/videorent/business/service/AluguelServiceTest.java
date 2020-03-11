package com.videorent.business.service;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Aluguel;
import com.videorent.business.model.Box;
import com.videorent.business.model.Cliente;
import com.videorent.business.model.Filme;
import com.videorent.business.model.enums.GeneroEnum;
import com.videorent.business.service.impl.AluguelServiceImpl;
import com.videorent.exception.BusinessException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.util.Date;
import java.util.HashSet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AluguelServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private IAluguelService servico;

    @Mock
    private DAO<Aluguel> dao;


    @Before
    public void init(){
        initMocks(this);
        servico = new AluguelServiceImpl(dao);
    }

    @Test
    public void deveInserirAluguel() throws BusinessException {

        Aluguel aluguel = initAluguel();
        servico.inserir(aluguel);
        verify(dao, times(1)).insert(aluguel);
    }

    @Test
    public void naoDeveInserirAluguelSemCliente() throws BusinessException {
        exceptionRule.expect(BusinessException.class);
        exceptionRule.expectMessage("Deve associar um cliente ao aluguel.");

        Aluguel aluguel = initAluguel();
        aluguel.setCliente(null);
        servico.inserir(aluguel);
     }

     @Test
     public void naoDeveInserirAluguelSemBoxes() throws BusinessException {
         exceptionRule.expect(BusinessException.class);
         exceptionRule.expectMessage("Aluguel nao possui filmes.");

         Aluguel aluguel = initAluguel();
         aluguel.setBoxes(new HashSet<>());
         servico.inserir(aluguel);
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
