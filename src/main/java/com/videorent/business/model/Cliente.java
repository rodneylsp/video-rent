package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements AbstractEntity, Serializable {

    @Id
    private Long id;
    private String nome;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
