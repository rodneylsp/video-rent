package com.videorent.business.service.impl;

import com.videorent.business.model.Aluguel;
import com.videorent.business.model.Box;
import com.videorent.business.service.IAluguelService;

import java.math.BigDecimal;
import java.util.Objects;

public class AluguelServiceImpl implements IAluguelService {

    public void inserir(Aluguel aluguel) {
        if(Objects.isNull(aluguel)){
            throw new IllegalArgumentException("Objeto vazio");
        }

        BigDecimal valorTotal = new BigDecimal(0);
        for(Box filme : aluguel.getFilmes()){
            valorTotal = valorTotal.add(filme.getPreco());
        }

        //TODO gravar na base
    }

}
