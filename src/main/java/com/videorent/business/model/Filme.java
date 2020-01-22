package com.videorent.business.model;

import com.videorent.business.model.enums.GeneroEnum;

public class Filme {

    private Long id;
    private String titulo;
    private Integer ano;
    private GeneroEnum genero;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public GeneroEnum getGenero() {
        return genero;
    }
    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }
}
