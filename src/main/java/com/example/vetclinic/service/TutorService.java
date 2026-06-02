package com.example.vetclinic.service;

import com.example.vetclinic.exception.EntidadeNaoEncontradaException;
import com.example.vetclinic.mapper.TutorMapper;
import com.example.vetclinic.model.dto.Request.TutorRequestDTO;
import com.example.vetclinic.model.dto.Response.TutorResponseDTO;
import com.example.vetclinic.model.entities.Tutor;
import com.example.vetclinic.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final TutorMapper tutorMapper;

    public List<TutorResponseDTO> listarTutor() {
        return tutorRepository.findAll()
                .stream()
                .map(tutorMapper::toResponse)
                .toList();
    }

    public TutorResponseDTO atualizarTutor(TutorRequestDTO dto, Long id) {
        Tutor t = tutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado"));
        t.setNome(dto.getNome());
        t.setEmail(dto.getEmail());

        if(t.getEndereco() != null) {
            t.getEndereco().setBairro(dto.getEndereco().getBairro());
            t.getEndereco().setCidade(dto.getEndereco().getCidade());
            t.getEndereco().setCep(dto.getEndereco().getCep());
            t.getEndereco().setRua(dto.getEndereco().getRua());
            t.getEndereco().setNumero(dto.getEndereco().getNumero());
        }

        Tutor tutorSalvo = tutorRepository.save(t);

        return tutorMapper.toResponse(tutorSalvo);
    }

    public TutorResponseDTO cadastrarTutor(TutorRequestDTO dto) {
        Tutor tutor = tutorMapper.toEntity(dto);
        Tutor tutorSalvo = tutorRepository.save(tutor);
        return tutorMapper.toResponse(tutorSalvo);
    }

    public void deletarTutor(Long id) {
        Tutor tutorEx = tutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado"));
        tutorRepository.delete(tutorEx);
    }

}
