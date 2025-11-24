package com.example.elbebestible.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Boolean rol;
    private String correo;
    private String contrasenna;

    //getters y setters id
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    //nombre
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    //rol
    public Boolean getRol() {return rol;}
    public void setRol(Boolean rol){this.rol=rol;}
    //correo
    public String getCorreo(){return correo;}
    public void setCorreo(String correo){this.correo=correo;}
    //contrasenna
    public String getContrasenna(){return contrasenna;}
    public void setContrasenna(String contrasenna){this.contrasenna=contrasenna;}
}
