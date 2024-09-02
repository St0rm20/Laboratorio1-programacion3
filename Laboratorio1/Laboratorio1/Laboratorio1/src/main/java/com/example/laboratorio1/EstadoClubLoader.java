package com.example.laboratorio1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EstadoClubLoader {

    public static Club cargarEstado() {
        Club club = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("club.dat"))) {
            club = (Club) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de estado: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada al leer el archivo de estado: " + e.getMessage());
        }
        return club;
    }
}