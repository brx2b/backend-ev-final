package com.example.elbebestible.controller;

import com.example.elbebestible.model.Persona;
import com.example.elbebestible.repository.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = {"http://localhost:3000", "https://frontend-fs-d.vercel.app"})
public class PersonaController {

    private final PersonaRepository repo;

    // Constructor
    public PersonaController(PersonaRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Persona personaNueva){
        // 1. Verificar si ya existe el correo
        Persona existente = repo.findByCorreo(personaNueva.getCorreo());

        if(existente != null){
            return ResponseEntity.status(409).body("El correo ya está registrado");
        }

        // 2. Guardar si no existe
        Persona personaGuardada = repo.save(personaNueva);
        return ResponseEntity.ok(personaGuardada);
    }

    // Listar
    @GetMapping
    public List<Persona> listar() {
        return repo.findAll();
    }

    // Registrar persona
    @PostMapping
    public Persona guardar(@RequestBody Persona persona) {
        return repo.save(persona);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona personaUpdate) {
        return repo.findById(id).map(persona -> {
            persona.setNombre(personaUpdate.getNombre());
            persona.setCorreo(personaUpdate.getCorreo());   // O email, según tu modelo
            persona.setContrasenna(personaUpdate.getContrasenna());
            persona.setRol(personaUpdate.getRol());
            return repo.save(persona);
        }).orElse(null);
    }


    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Persona loginData) {

        Persona persona = repo.findByCorreo(loginData.getCorreo());

        if (persona == null) {
            return ResponseEntity.status(401).body("Correo incorrecto");
        }

        if (!persona.getContrasenna().equals(loginData.getContrasenna())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(persona);
    }
}
