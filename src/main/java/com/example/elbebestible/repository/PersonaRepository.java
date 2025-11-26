package com.example.elbebestible.repository;

import com.example.elbebestible.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByCorreo(String correo);
}
