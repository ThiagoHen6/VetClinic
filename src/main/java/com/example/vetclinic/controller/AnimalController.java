package com.example.vetclinic.controller;

import com.example.vetclinic.model.dto.Request.AnimalRequestDTO;
import com.example.vetclinic.model.dto.Response.AnimalResponseDTO;
import com.example.vetclinic.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tutores/{tutorId}/animais")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping
    public ResponseEntity<Page<AnimalResponseDTO>> listar(Pageable pageable, @PathVariable Long tutorId) {
        return ResponseEntity.ok(animalService.listarAnimais(tutorId, pageable));
    }

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> cadastrar(@RequestBody @Valid AnimalRequestDTO animalRequestDTO,
                                                       @PathVariable Long tutorId) {
        return ResponseEntity.status(201).body(animalService.cadastrarAnimal(animalRequestDTO, tutorId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> atualizar(@PathVariable Long id,
                                                       @RequestBody @Valid AnimalRequestDTO animalRequestDTO,
                                                       @PathVariable Long tutorId) {
        return ResponseEntity.ok(animalService.atualizarAnimal(id, animalRequestDTO, tutorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id, @PathVariable Long tutorId) {
        animalService.deletarAnimal(id, tutorId);
        return ResponseEntity.noContent().build();
    }
}
