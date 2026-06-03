package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    public Consulta(LocalDate dataConsulta, LocalTime horaConsulta, StatusConsulta status, Animal animal, Veterinario veterinario) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.status = status;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public Consulta() {}
}
