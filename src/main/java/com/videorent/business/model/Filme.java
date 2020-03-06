package com.videorent.business.model;

import com.videorent.business.model.enums.GeneroEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILME")
@Getter
@Setter
@NoArgsConstructor
public class Filme implements AbstractEntity {

    private Long id;
    private String titulo;
    private Integer ano;
    private GeneroEnum genero;

}
