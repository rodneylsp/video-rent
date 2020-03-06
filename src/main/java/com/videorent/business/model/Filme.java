package com.videorent.business.model;

import com.videorent.business.model.enums.GeneroEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FILME")
@Getter
@Setter
@NoArgsConstructor
public class Filme implements AbstractEntity, Serializable {

    @Id
    private Long id;
    private String titulo;
    private Integer ano;
    private GeneroEnum genero;

}
