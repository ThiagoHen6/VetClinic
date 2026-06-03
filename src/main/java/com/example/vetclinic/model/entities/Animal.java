package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String petName;
    @Enumerated(EnumType.STRING)
    private TipoAnimal tipo;
    private String race;
    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultas;

}
