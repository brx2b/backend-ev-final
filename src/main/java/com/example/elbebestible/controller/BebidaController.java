package com.example.elbebestible.controller;

import com.example.elbebestible.model.Bebida;
import com.example.elbebestible.repository.BebidaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bebidas")
@CrossOrigin("*")
public class BebidaController {
    private final BebidaRepository repo;

    //Constructor
    public BebidaController(BebidaRepository repo){
        this.repo=repo;
    }
    //Listar
    @GetMapping
    public List<Bebida> listar(){
        return repo.findAll();
    }

    //Guardar
    @PostMapping
    public Bebida guardar(@RequestBody Bebida bebida){
        return repo.save(bebida);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(Double.valueOf(id));
    }
}