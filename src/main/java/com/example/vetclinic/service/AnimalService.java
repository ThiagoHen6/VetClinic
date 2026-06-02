package com.example.vetclinic.service;

import com.example.vetclinic.exception.AnimalNaoPertenceAoTutorException;
import com.example.vetclinic.exception.EntidadeNaoEncontradaException;
import com.example.vetclinic.mapper.AnimalMapper;
import com.example.vetclinic.model.dto.Request.AnimalRequestDTO;
import com.example.vetclinic.model.dto.Response.AnimalResponseDTO;
import com.example.vetclinic.model.entities.Animal;
import com.example.vetclinic.model.entities.Tutor;
import com.example.vetclinic.repository.AnimalRepository;
import com.example.vetclinic.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final TutorRepository tutorRepository;

    public Page<AnimalResponseDTO> listarAnimais(Long tutorId, Pageable pageable) {
        return animalRepository.findByTutorId(tutorId, pageable)
                .map(animalMapper::toResponse);
    }

    public AnimalResponseDTO cadastrarAnimal(AnimalRequestDTO dto, Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado"));
        Animal animal = animalMapper.toEntity(dto);
        animal.setTutor(tutor);
        Animal animalSalvo = animalRepository.save(animal);
        return animalMapper.toResponse(animalSalvo);
    }

    public AnimalResponseDTO atualizarAnimal(Long id, AnimalRequestDTO dto, Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado"));
        Animal animalEx = animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado"));

        if(!animalEx.getTutor().getId().equals(tutor.getId())) {
            throw new AnimalNaoPertenceAoTutorException("Este animal não lhe pertence");
        }

        animalEx.setTipo(dto.getTipo());
        animalEx.setRace(dto.getRace());
        animalEx.setPetName(dto.getPetName());
        return animalMapper.toResponse(animalRepository.save(animalEx));
    }

    public void deletarAnimal(Long id, Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado"));
        Animal animalEx = animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado"));
        if(!animalEx.getTutor().getId().equals(tutor.getId())) {
            throw new AnimalNaoPertenceAoTutorException("Este animal não lhe pertence");
        }
        animalRepository.delete(animalEx);
    }
}
