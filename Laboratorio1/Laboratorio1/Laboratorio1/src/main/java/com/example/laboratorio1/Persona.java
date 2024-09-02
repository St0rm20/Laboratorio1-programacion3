package com.example.laboratorio1;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String Id;

    public Persona(String nombre, String Id) {
        this.nombre = nombre;
        this.Id = Id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
}

