package com.example.vetclinic.controller;

import com.example.vetclinic.model.dto.Request.VeterinarioRequestDTO;
import com.example.vetclinic.model.dto.Response.VeterinarioResponseDTO;
import com.example.vetclinic.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {
    private final VeterinarioService veterinarioService;

    @GetMapping
    public ResponseEntity<List<VeterinarioResponseDTO>> listar() {
        return ResponseEntity.ok(veterinarioService.listarVeterinarios());
    }

    @PostMapping
    public ResponseEntity<VeterinarioResponseDTO> cadastrar(@RequestBody @Valid VeterinarioRequestDTO vet) {
        return ResponseEntity.status(201).body(veterinarioService.cadastrarVeterinario(vet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid VeterinarioRequestDTO vet) {
        return ResponseEntity.ok(veterinarioService.atualizarVeterinario(vet, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veterinarioService.deletarVeterinario(id);
        return ResponseEntity.noContent().build();
    }
}
