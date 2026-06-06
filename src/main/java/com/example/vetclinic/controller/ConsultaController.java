package com.example.vetclinic.controller;

import com.example.vetclinic.model.dto.Request.ConsultaRequestDTO;
import com.example.vetclinic.model.dto.Response.ConsultaResponseDTO;
import com.example.vetclinic.model.entities.StatusConsulta;
import com.example.vetclinic.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConsultaController {
    private final ConsultaService consultaService;

    @GetMapping("/veterinarios/{veterinarioId}/consultas")
    public ResponseEntity<Page<ConsultaResponseDTO>> listarPorVeterinario(Pageable pageable,
                                                                          @PathVariable Long veterinarioId) {
        return ResponseEntity.ok(consultaService.listarConsultasPorVeterinario(pageable, veterinarioId));
    }

    @GetMapping("/animais/{animalId}/consultas")
    public ResponseEntity<Page<ConsultaResponseDTO>> listarPorAnimal(Pageable pageable,
                                                                     @PathVariable Long animalId) {
        return ResponseEntity.ok(consultaService.listarConsultasPorAnimal(pageable, animalId));
    }

    @PostMapping("/tutores/{tutorId}/consultas")
    public ResponseEntity<ConsultaResponseDTO> agendar(@RequestBody @Valid ConsultaRequestDTO consultaRequestDTO,
                                                               @PathVariable Long tutorId) {
        return ResponseEntity.status(201).body(consultaService.agendarConsulta(consultaRequestDTO, tutorId));
    }

    @PutMapping("/consultas/{id}/status")
    public ResponseEntity<ConsultaResponseDTO> atualizar(@PathVariable Long id,
                                                         @RequestParam StatusConsulta status) {
        return ResponseEntity.ok(consultaService.atualizarConsulta(id, status));
    }

    @PutMapping("/consultas/{id}")
    public ResponseEntity<ConsultaResponseDTO> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.cancelarConsulta(id));
    }
}
