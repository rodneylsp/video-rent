package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements AbstractEntity {

    @Id
    private Long id;
    private String nome;

}
