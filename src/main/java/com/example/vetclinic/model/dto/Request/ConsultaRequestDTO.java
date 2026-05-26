package com.example.vetclinic.model.dto.Request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaRequestDTO {
    private LocalDate data;
    private LocalTime hora;
    private String status;
    private Long animalId;
    private Long veterinarioId;
}
