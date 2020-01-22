package com.videorent.business.model;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class Aluguel {

    private Long id;
    private Date data;
    private Cliente cliente;
    private List<Box> filmes;
    private Currency total;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Box> getFilmes() {
        return filmes;
    }
    public void setFilmes(List<Box> filmes) {
        this.filmes = filmes;
    }
    public Currency getTotal() {
        return total;
    }
    public void setTotal(Currency total) {
        this.total = total;
    }

}
