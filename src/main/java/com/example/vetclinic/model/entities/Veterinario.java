package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "veterinario_especialidades",
            joinColumns = @JoinColumn(name = "veterinario_id")
    )
    @Column(name = "tipo_animal")
    private List<TipoAnimal> especialidades;
    @ManyToMany(mappedBy = "veterinariosPreferidos")
    private List<Tutor> tutores;
}
