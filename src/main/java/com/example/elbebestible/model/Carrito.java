package com.example.elbebestible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrito {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Bebida bebida;

    private int cantidad;

    //getters y setters

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Persona getPersona() {return persona;}
    public void setPersona(Persona persona){this.persona=persona;}

    public Bebida getBebida(){return bebida;}
    public void setBebida(Bebida bebida){this.bebida=bebida;}

    public int getCantidad(){return cantidad;}
    public void setCantidad(int cantidad){this.cantidad=cantidad;}
}
