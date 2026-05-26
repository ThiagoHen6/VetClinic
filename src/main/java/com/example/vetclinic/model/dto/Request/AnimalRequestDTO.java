package com.example.vetclinic.model.dto.Request;

import com.example.vetclinic.model.entities.TipoAnimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalRequestDTO {
    @NotBlank(message = "O animal precisa de um nome")
    private String petName;
    @NotBlank(message = "É obrigatório o animal ter uma raça")
    private String race;
    @NotNull(message = "O que é seu animal?")
    private TipoAnimal tipo;
}
