package com.example.elbebestible.controller;

import com.example.elbebestible.model.Persona;
import com.example.elbebestible.repository.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaRepository repo;

    public PersonaController(PersonaRepository repo){
        this.repo = repo;
    }

    //get
    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }
    //guardar
    @PostMapping
    public Persona guardar(@RequestBody Persona persona){
        return repo.save(persona);
    }
    //eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(id);
    }
    //actualizar put
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona personaUpdate){
        return repo.findById(id).map(p -> {
            p.setNombre(personaUpdate.getNombre());
            p.setCorreo(personaUpdate.getCorreo());
            p.setContrasenna(personaUpdate.getContrasenna());
            p.setRol(personaUpdate.getRol());
            return repo.save(p);
        }).orElse(null);
    }

    //registro
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Persona persona){

        // Validar si el correo ya existe
        if (repo.findByCorreo(persona.getCorreo()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("El correo ya está registrado");
        }

        Persona nueva = repo.save(persona);
        return ResponseEntity.ok(nueva);
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Persona datosLogin){

        return repo.findByCorreo(datosLogin.getCorreo())
                .map(p -> {
                    if (p.getContrasenna().equals(datosLogin.getContrasenna())) {
                        return ResponseEntity.ok(p);
                    } else {
                        return ResponseEntity.badRequest().body("Contraseña incorrecta");
                    }
                })
                .orElse(ResponseEntity.badRequest().body("Correo no encontrado"));
    }
}
