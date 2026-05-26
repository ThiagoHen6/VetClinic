package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

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
    @JoinColumn(name="id_tutor")
    private Tutor tutor;
}
