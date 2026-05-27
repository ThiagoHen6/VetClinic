package com.example.vetclinic.model.dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaRequestDTO {
    @NotNull(message = "Data é obrigatória")
    private LocalDate data;
    @NotNull(message = "Hora é obrigatória")
    private LocalTime hora;
    private String status;
    @NotNull(message = "Animal é obrigatório")
    private Long animalId;
    @NotNull(message = "Veterinário é obrigatório")
    private Long veterinarioId;
}
