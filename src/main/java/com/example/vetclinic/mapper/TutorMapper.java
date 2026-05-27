package com.example.vetclinic.mapper;

import com.example.vetclinic.model.dto.EnderecoDTO;
import com.example.vetclinic.model.dto.Request.TutorRequestDTO;
import com.example.vetclinic.model.dto.Response.TutorResponseDTO;
import com.example.vetclinic.model.entities.Endereco;
import com.example.vetclinic.model.entities.Tutor;
import org.springframework.stereotype.Component;

@Component
public class TutorMapper {
    public Tutor toEntity(TutorRequestDTO dto) {
        Tutor t = new Tutor();
        t.setEmail(dto.getEmail());
        t.setNome(dto.getNome());

        EnderecoDTO endDto = dto.getEndereco();
        Endereco end = new Endereco();
        end.setBairro(endDto.getBairro());
        end.setCidade(endDto.getCidade());
        end.setCep(endDto.getCep());
        end.setRua(endDto.getRua());
        end.setNumero(endDto.getNumero());
        end.setTutor(t);

        t.setEndereco(end);
        return t;
    }

    public TutorResponseDTO toResponse(Tutor t) {
        TutorResponseDTO dto = new TutorResponseDTO();
        dto.setId(t.getId());
        dto.setNome(t.getNome());
        return dto;
    }
}
