package com.example.laboratorio1;
import java.io.Serializable;


import java.time.LocalDate;

public class Administrador extends Persona implements Serializable{

    private static final long serialVersionUID = 1L;

    public Administrador(String  nombre, String id ) {
        super(nombre, id);
    }


    public void agregarDeporte(Deporte deporte){
        if (deporte !=null){

        }
    }
    public void ProgramarEntrenamiento(Deporte deporte , Entrenador entrenador, LocalDate fecha, Boolean estado, int duracion){
        Entrenamiento entrenamiento = new Entrenamiento(fecha, duracion, estado, entrenador, deporte);
        entrenador.agregarSesion(entrenamiento);
    }

    public void cancelarEntrenamiento(Entrenamiento entrenamiento){
        entrenamiento.getEntrenador().getEntrenamientos().remove(entrenamiento);
    }

    public void  CambiarFechaEntrenamiento(Entrenamiento entrenamiento, Entrenador entrenador, LocalDate date){
        for (int i= 0; i < entrenador.getEntrenamientos().size(); i++){
            Entrenamiento entrenamiento1=entrenador.getEntrenamientos().get(i);
            if (entrenamiento1.equals(entrenamiento)){
                entrenamiento1.setFecha(date);
                break;
            }
        }
    }
}
