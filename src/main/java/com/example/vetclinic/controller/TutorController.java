package com.example.vetclinic.controller;

import com.example.vetclinic.model.dto.Request.TutorRequestDTO;
import com.example.vetclinic.model.dto.Response.TutorResponseDTO;
import com.example.vetclinic.service.TutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {
    private final TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> listar() {
        return ResponseEntity.ok(tutorService.listarTutor());
    }

    @PostMapping
    public ResponseEntity<TutorResponseDTO> cadastrar(@RequestBody @Valid TutorRequestDTO tutorRequestDTO) {
        return ResponseEntity.status(201).body(tutorService.cadastrarTutor(tutorRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TutorRequestDTO tutorRequestDTO) {
        return ResponseEntity.ok(tutorService.atualizarTutor(tutorRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tutorService.deletarTutor(id);
        return ResponseEntity.noContent().build();
    }
}
