package com.example.laboratorio1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EstadoClubSaver {

    public static void guardarEstado(Club club) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("club.dat"))) {
            oos.writeObject(club);
        } catch (IOException e) {
            System.out.println("Error al guardar el estado: " + e.getMessage());
        }
    }
}