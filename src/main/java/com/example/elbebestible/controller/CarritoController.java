package com.example.elbebestible.controller;

import com.example.elbebestible.model.Carrito;
import com.example.elbebestible.repository.CarritoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/carrito")
@CrossOrigin("*")
public class CarritoController {
    private final CarritoRepository repo;

    public CarritoController(CarritoRepository repo){
        this.repo=repo;
    }

    @GetMapping("/persona/{idPersona}")
    public List<Carrito> verCarrito(@PathVariable Long idPersona){
        return repo.findByPersonaId(idPersona);
    }


    @PostMapping
    public Carrito agregar(@RequestBody Carrito carrito){
        return repo.save(carrito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(id);
    }
}
