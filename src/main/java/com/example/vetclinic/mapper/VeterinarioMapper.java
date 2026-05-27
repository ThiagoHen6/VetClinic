package com.example.vetclinic.mapper;

import com.example.vetclinic.model.dto.Request.VeterinarioRequestDTO;
import com.example.vetclinic.model.entities.Veterinario;
import org.springframework.stereotype.Component;

@Component
public class VeterinarioMapper {
    public Veterinario toEntity(VeterinarioRequestDTO dto) {
        Veterinario v = new Veterinario();
        v.setEspecialidades(dto.getEspecialidades());
        v.setNome(dto.getNome());
        return v;
    }

    public VeterinarioRequestDTO toResponse(Veterinario v) {
        VeterinarioRequestDTO dto = new VeterinarioRequestDTO();
        dto.setEspecialidades(v.getEspecialidades());
        dto.setNome(v.getNome());
        return dto;
    }
}
