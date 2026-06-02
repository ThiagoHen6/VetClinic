package com.example.vetclinic.model.dto.Response;

import com.example.vetclinic.model.entities.StatusConsulta;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaResponseDTO {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private StatusConsulta status;
    private Long animalId;
    private Long veterinarioId;
    private String petName;
    private String veterinarioNome;
}
