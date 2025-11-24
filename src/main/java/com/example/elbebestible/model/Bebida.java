package com.example.elbebestible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double litros;
    private Float valor;
    private String imagenUrl;
    //getters y setters id
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    //nombre
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    //litros
    public Double getLitros(){return litros;}
    public void setLitros(Double litros){this.litros=litros;}

    //valor
    public Float getValor(){return valor;}
    public void setValor(Float valor){this.valor=valor;}

    //imagenUrl
    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}
