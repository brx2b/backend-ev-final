package com.example.elbebestible.repository;

import com.example.elbebestible.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByCorreo(String correo);
}
