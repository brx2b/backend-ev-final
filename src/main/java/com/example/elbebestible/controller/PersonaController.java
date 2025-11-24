package com.example.elbebestible.controller;

import com.example.elbebestible.model.Persona;
import com.example.elbebestible.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/personas")
@CrossOrigin("*")
public class PersonaController {
    private final PersonaRepository repo;

    //Constructor
    public PersonaController(PersonaRepository repo){
        this.repo=repo;
    }
    //Listar
    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    //Guardar
    @PostMapping
    public Persona guardar(@RequestBody Persona persona){
        return repo.save(persona);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona p){
        return repo.findById(id).map(persona -> {
            persona.setNombre(p.getNombre());
            persona.setCorreo(p.getCorreo());
            persona.setContrasenna(p.getContrasenna());
            persona.setRol(p.getRol());
            return repo.save(persona);
        }).orElse(null);
    }
}
