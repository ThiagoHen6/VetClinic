package com.example.vetclinic.model.dto.Response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaResponseDTO {
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String status;
    private Long animalId;
    private Long veterinarioId;
}
