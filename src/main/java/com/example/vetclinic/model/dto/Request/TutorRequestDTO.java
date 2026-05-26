package com.example.vetclinic.model.dto.Request;

import com.example.vetclinic.model.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TutorRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O email é obrigatório")
    private String email;
    private Endereco endereco;
}
