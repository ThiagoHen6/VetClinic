package com.example.vetclinic.model.dto.Request;

import com.example.vetclinic.model.entities.TipoAnimal;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class VeterinarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    private List<TipoAnimal> especialidades;
}
