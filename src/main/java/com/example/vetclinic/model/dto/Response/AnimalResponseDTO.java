package com.example.vetclinic.model.dto.Response;

import com.example.vetclinic.model.entities.TipoAnimal;
import lombok.Data;

@Data
public class AnimalResponseDTO {
    private Long id;
    private String petName;
    private String race;
    private TipoAnimal tipo;
    private Long tutorId;
}
