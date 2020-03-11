package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;


@Entity
@Table(name = "BOX")
@Getter
@Setter
@NoArgsConstructor
public class Box implements AbstractEntity, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "BOX_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Filme filme;

    @Column(name = "BOX_PRECO")
    private Double preco;

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", preco=" + preco +
                '}';
    }
}
