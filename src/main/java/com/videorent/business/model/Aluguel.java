package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ALUGUEL")
@Getter
@Setter
@NoArgsConstructor
public class Aluguel implements AbstractEntity {

    @Id
    private Long id;
    private Date data;
    private Cliente cliente;
    private List<Box> filmes;
    private Currency total;

 }
