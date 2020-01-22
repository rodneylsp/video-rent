package com.videorent.business.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Box {

    private Long id;
    private Filme filme;
    private BigDecimal preco; //TODO mudar para Currency

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
