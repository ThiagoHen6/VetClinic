package com.example.vetclinic.model.dto.Request;

import com.example.vetclinic.model.entities.StatusConsulta;
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
    @NotNull(message = "Status é obrigatório")
    private StatusConsulta status;
    @NotNull(message = "Animal é obrigatório")
    private Long animalId;
    @NotNull(message = "Veterinário é obrigatório")
    private Long veterinarioId;
}
