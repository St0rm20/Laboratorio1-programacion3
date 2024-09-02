package com.controller.laboratorio1;

import com.example.laboratorio1.Deporte;
import com.example.laboratorio1.Deporte;
import com.example.laboratorio1.Entrenador;
import com.example.laboratorio1.NivelDificultad;
import java.util.ArrayList;
import java.util.List;

public class DeporteController {
    private  Deporte deporte;

    public DeporteController() {
        this.deporte = deporte;
    }

    public Deporte getDeportes() {
        return deporte;
    }

    public void agregarEntrenador(Entrenador entrenador) {
        deporte.agregarEntrenador(entrenador);
    }

}
