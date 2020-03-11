package com.videorent.business.model;

import com.videorent.business.model.enums.GeneroEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILME")
@Getter
@Setter
@NoArgsConstructor
public class Filme implements AbstractEntity, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "FILM_ID")
    private Long id;

    @Column(name = "FILM_TITULO")
    private String titulo;

    @Column(name = "FILM_ANO")
    private Integer ano;

    @Column(name = "FILM_GENERO")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", genero=" + genero +
                '}';
    }
}
