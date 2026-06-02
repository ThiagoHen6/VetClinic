package com.example.vetclinic.mapper;

import com.example.vetclinic.model.dto.Request.AnimalRequestDTO;
import com.example.vetclinic.model.dto.Response.AnimalResponseDTO;
import com.example.vetclinic.model.entities.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public AnimalResponseDTO toResponse(Animal a) {
        AnimalResponseDTO dto = new AnimalResponseDTO();
        dto.setId(a.getId());
        dto.setRace(a.getRace());
        dto.setTipo(a.getTipo());
        dto.setPetName(a.getPetName());
        dto.setTutorId(a.getTutor().getId());
        return dto;
    }

    public Animal toEntity(AnimalRequestDTO dto) {
        Animal a = new Animal();
        a.setTipo(dto.getTipo());
        a.setPetName(dto.getPetName());
        a.setRace(dto.getRace());
        return a;
    }
}
