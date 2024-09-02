package com.example.laboratorio1;

import java.io.Serializable;
import java.time.LocalDate;

public class Entrenamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate fecha;
    private int duracion;
    private boolean estadoEntrenamiento;
    private Entrenador entrenador;
    private Deporte deporte;

    public Entrenamiento(LocalDate fecha, int duracion, boolean estadoEntrenamiento, Entrenador entrenador, Deporte deporte) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.estadoEntrenamiento = estadoEntrenamiento;
        this.deporte = deporte;
        this.entrenador = entrenador;
    }

    public int getDuracion() {
        return duracion;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public boolean getEstadoEntrenamiento() {
        return false;
    }
    public void setEstadoEntrenamiento(boolean estadoEntrenamiento) {
        this.estadoEntrenamiento = estadoEntrenamiento;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

}
