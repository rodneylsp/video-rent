package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Currency;


@Entity
@Table(name = "BOX")
@Getter
@Setter
@NoArgsConstructor
public class Box implements AbstractEntity {

    private Long id;
    private Filme filme;
    private Currency preco;

 }
