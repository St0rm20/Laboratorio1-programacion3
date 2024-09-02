package com.example.laboratorio1;

import com.controller.laboratorio1.AdministradorController;

import java.io.Serializable;
import java.util.ArrayList;

public class Club implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList <Entrenador> entrenadores;
    private ArrayList<Deporte> deportes;
    private ArrayList<Miembro>miembros;
    private Administrador administrador;

    public Club(Administrador administrador) {
        this.administrador = administrador;
        this.deportes = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setDeportes(ArrayList<Deporte> deportes) {
        this.deportes = deportes;
    }

    public ArrayList<Deporte> getDeportes() {
        return deportes;
    }
    public void setDeportes(Deporte deporte) {
        this.deportes.add(deporte);
    }

    public void setMiembros(ArrayList<Miembro> miembros) {
        this.miembros = miembros;
    }

    public void agregarDeporte(Deporte deporte){
        deportes.add(deporte);
    }


    public void agregarMiembro(Miembro miembro, Deporte deporte){
        if (miembro.getTipoMiembro()==TipoMiembro.JUVENIL && deporte.getNivelDificultad()==NivelDificultad.ALTO){
            return;
        }
        miembros.add(miembro);
    }

    public void agregarEntrenador(Entrenador entrenador){
        entrenadores.add(entrenador);
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

}
