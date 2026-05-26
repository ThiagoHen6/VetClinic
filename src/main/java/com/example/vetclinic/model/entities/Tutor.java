package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id")
    private Endereco endereco;
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Animal> animais;

}
