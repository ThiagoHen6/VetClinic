package com.example.vetclinic.service;

import com.example.vetclinic.exception.EntidadeNaoEncontradaException;
import com.example.vetclinic.mapper.VeterinarioMapper;
import com.example.vetclinic.model.dto.Request.VeterinarioRequestDTO;
import com.example.vetclinic.model.dto.Response.VeterinarioResponseDTO;
import com.example.vetclinic.model.entities.Veterinario;
import com.example.vetclinic.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioService {
    private final VeterinarioRepository veterinarioRepository;
    private final VeterinarioMapper mapper;

    public VeterinarioResponseDTO cadastrarVeterinario(VeterinarioRequestDTO dto) {
        Veterinario vet = mapper.toEntity(dto);
        Veterinario vetSalvo = veterinarioRepository.save(vet);
        return mapper.toResponse(vetSalvo);
    }

    public List<VeterinarioResponseDTO> listarVeterinarios() {
        return veterinarioRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public VeterinarioResponseDTO atualizarVeterinario(VeterinarioRequestDTO dto, Long id) {
        Veterinario vetEx = veterinarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado"));
        vetEx.setNome(dto.getNome());
        vetEx.setEspecialidades(dto.getEspecialidades());

        Veterinario vetAtualizado = veterinarioRepository.save(vetEx);
        return mapper.toResponse(vetAtualizado);
    }

    public void deletarVeterinario(Long id) {
        Veterinario vetEx = veterinarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado"));
        veterinarioRepository.delete(vetEx);
    }
}
