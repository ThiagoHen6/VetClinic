package com.example.vetclinic.repository;

import com.example.vetclinic.model.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
