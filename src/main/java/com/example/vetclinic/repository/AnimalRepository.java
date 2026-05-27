package com.example.vetclinic.repository;

import com.example.vetclinic.model.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Page<Animal> findByTutorId(Long id, Pageable pageable);
}
