package com.example.elbebestible.repository;
import com.example.elbebestible.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    List<Carrito> findByPersonaId(Long personaid);
}
