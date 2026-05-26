package com.example.vetclinic.model.dto.Request;

import com.example.vetclinic.model.entities.TipoAnimal;
import com.example.vetclinic.model.entities.Tutor;
import com.example.vetclinic.model.entities.Veterinario;
import lombok.Data;

import java.util.List;

@Data
public class VeterinarioRequest {
    private String nome;
    private List<TipoAnimal> especialidades;
    private List<Tutor> tutores;
}
