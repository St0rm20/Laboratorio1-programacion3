package com.example.laboratorio1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deporte implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String descripcion;
    private ArrayList<Entrenador>entrenadores;
    private NivelDificultad nivelDificultad;

    public Deporte(String nombre, String descripcion, NivelDificultad nivelDificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
        this.entrenadores = new ArrayList();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }
    public void setEntrenadores(List entreanadores) {
        this.entrenadores = new ArrayList();
    }

    public NivelDificultad getNivelDificultad() {
        return nivelDificultad;
    }

    public void agregarEntrenador(Entrenador entrenador){
        entrenadores.add(entrenador);
    }

    public void setNivelDificultad(NivelDificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
}
