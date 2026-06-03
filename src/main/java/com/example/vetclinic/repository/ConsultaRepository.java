package com.example.vetclinic.repository;

import com.example.vetclinic.model.entities.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findByAnimalId(Long id, Pageable pageable);
    Page<Consulta> findByVeterinarioId(Long id, Pageable pageable);

    boolean existsByVeterinarioIdAndDataConsultaAndHoraConsulta(Long veterinarioId, LocalDate dataConsulta, LocalTime horaConsulta);
}
