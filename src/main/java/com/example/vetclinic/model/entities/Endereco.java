package com.example.vetclinic.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String cidade;
    private String cep;
    private String rua;
    private String numero;
    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;


}
