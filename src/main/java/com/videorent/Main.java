package com.videorent;

import com.videorent.business.model.Aluguel;
import com.videorent.business.model.Box;
import com.videorent.business.model.Cliente;
import com.videorent.business.model.Filme;
import com.videorent.business.model.enums.GeneroEnum;

import java.util.Date;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

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
    }
}
