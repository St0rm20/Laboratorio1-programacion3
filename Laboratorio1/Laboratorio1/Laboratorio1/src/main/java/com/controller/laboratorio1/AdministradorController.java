package com.controller.laboratorio1;


import com.example.laboratorio1.Administrador;
import com.example.laboratorio1.Deporte;
import com.example.laboratorio1.Entrenador;
import com.example.laboratorio1.Entrenamiento;

import java.time.LocalDate;

public class AdministradorController {

    private Administrador administrador;

    public AdministradorController(Administrador administrador) {
        this.administrador = administrador;
    }

    public void programarEntrenamiento(Deporte deporte , Entrenador entrenador, LocalDate fecha, Boolean estado, int duracion) {
        administrador.ProgramarEntrenamiento(deporte, entrenador, fecha, estado, duracion);
    }

    public void cancelarEntrenamiento(Entrenamiento entrenamiento) {
        administrador.cancelarEntrenamiento(entrenamiento);
    }

    public void cambiarFechaEntrenamiento(Entrenamiento entrenamiento, LocalDate nuevaFecha) {
        administrador.CambiarFechaEntrenamiento(entrenamiento, entrenamiento.getEntrenador(), nuevaFecha);
    }
}

