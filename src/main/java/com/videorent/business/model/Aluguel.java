package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ALUGUEL")
@Getter
@Setter
@NoArgsConstructor
public class Aluguel implements AbstractEntity, Serializable {

    @Id
    private Long id;
    private Date data;
    private Cliente cliente;
    @Transient
    private List<Box> filmes;
    private Currency total;

 }
