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

    //actualizar
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona personaUpdate){
        return repo.findById(id).map(persona -> {
            persona.setNombre(personaUpdate.getNombre());
            persona.setCorreo(personaUpdate.getCorreo());
            persona.setContrasenna(personaUpdate.getContrasenna());
            persona.setRol(personaUpdate.getRol());
            return repo.save(persona);
        }).orElse(null);
    }
}
