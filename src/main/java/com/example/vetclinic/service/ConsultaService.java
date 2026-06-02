package com.example.vetclinic.service;

import com.example.vetclinic.exception.EntidadeNaoEncontradaException;
import com.example.vetclinic.mapper.ConsultaMapper;
import com.example.vetclinic.model.dto.Response.ConsultaResponseDTO;
import com.example.vetclinic.model.entities.Consulta;
import com.example.vetclinic.model.entities.StatusConsulta;
import com.example.vetclinic.repository.AnimalRepository;
import com.example.vetclinic.repository.ConsultaRepository;
import com.example.vetclinic.repository.TutorRepository;
import com.example.vetclinic.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final ConsultaMapper consultaMapper;

    public Page<ConsultaResponseDTO> listarConsultasPorAnimal(Pageable pageable, Long animalId) {
        return consultaRepository.findByAnimalId(animalId, pageable)
                .map(consultaMapper::toResponse);
    }

    public Page<ConsultaResponseDTO> listarConsultasPorVeterinario(Pageable pageable, Long veterinarioId) {
        return consultaRepository.findByVeterinarioId(veterinarioId, pageable)
                .map(consultaMapper::toResponse);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, StatusConsulta stts) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Consulta não agendada"));
        consulta.setStatus(stts);
        Consulta consultaAtualizada = consultaRepository.save(consulta);
        return consultaMapper.toResponse(consultaAtualizada);
    }

    public ConsultaResponseDTO cancelarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Consulta não agendada"));
        consulta.setStatus(StatusConsulta.CANCELADA);
        Consulta consultaAtualizada = consultaRepository.save(consulta);
        return consultaMapper.toResponse(consultaAtualizada);
    }



}
