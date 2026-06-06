package com.example.vetclinic.mapper;

import com.example.vetclinic.model.dto.Request.ConsultaRequestDTO;
import com.example.vetclinic.model.dto.Response.ConsultaResponseDTO;
import com.example.vetclinic.model.entities.Consulta;
import org.springframework.stereotype.Component;

@Component
public class ConsultaMapper {
    public Consulta toEntity(ConsultaRequestDTO dto) {
        Consulta c = new Consulta();
        c.setHoraConsulta(dto.getHora());
        c.setDataConsulta(dto.getData());
        c.setStatus(dto.getStatus());
        return c;
    }

    public ConsultaResponseDTO toResponse(Consulta c) {
        ConsultaResponseDTO dto = new ConsultaResponseDTO();
        dto.setHora(c.getHoraConsulta());
        dto.setData(c.getDataConsulta());
        dto.setStatus(c.getStatus());
        dto.setAnimalId(c.getAnimal().getId());
        dto.setVeterinarioId(c.getVeterinario().getId());
        dto.setId(c.getId());
        dto.setPetName(c.getAnimal().getPetName());
        dto.setVeterinarioNome(c.getVeterinario().getNome());
        return dto;
    }
}
