package com.example.vetclinic.model.dto.Response;

import com.example.vetclinic.model.entities.TipoAnimal;
import lombok.Data;

import java.util.List;

@Data
public class VeterinarioResponseDTO {
    private Long id;
    private String nome;
    private List<TipoAnimal> especialidades;
}
