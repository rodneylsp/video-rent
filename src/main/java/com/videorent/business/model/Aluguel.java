package com.videorent.business.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ALUGUEL")
@Getter
@Setter
@NoArgsConstructor
public class Aluguel implements AbstractEntity, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ALUG_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "ALUG_DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "CLIE_ID")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "ALUGUEL_BOX",
        joinColumns = @JoinColumn(name = "ALUG_ID"),
        inverseJoinColumns = @JoinColumn(name = "BOX_ID"))
    private Set<Box> boxes;

    @Column(name = "ALUG_TOTAL")
    private Double total;

 }
