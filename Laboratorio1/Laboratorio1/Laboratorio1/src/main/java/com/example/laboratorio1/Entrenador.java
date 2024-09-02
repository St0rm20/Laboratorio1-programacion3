package com.example.laboratorio1;

import java.io.Serializable;
import java.util.ArrayList;

public class Entrenador extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String especialidad;
    private ArrayList<Entrenamiento> entrenamientos;

    // Constructor corregido para inicializar entrenamientos
    public Entrenador(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.entrenamientos = new ArrayList<>(); // Inicializa la lista
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void agregarSesion(Entrenamiento entrenamiento) {
        entrenamientos.add(entrenamiento);
    }

    public ArrayList<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    // Método corregido para coincidir con el constructor
    public static Entrenador fromFileFormat(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) { // Asegúrate de que el número de partes coincida
            throw new IllegalArgumentException("Formato de línea no válido.");
        }
        String nombre = parts[0].trim();
        String id = parts[1].trim();
        String especialidad = parts[2].trim(); // Cambié 'correoElectronico' a 'especialidad'

        return new Entrenador(nombre, id, especialidad);
    }

    public String toFileFormat() {
        return getNombre() + "," + getId() + "," + getEspecialidad();
    }
}
