package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements AbstractEntity, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CLIE_ID")
    private Long id;

    @Column(name = "CLIE_NOME")
    private String nome;

    @OneToMany(mappedBy = "cliente")
    private Set<Aluguel> historicoAlugueis;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
