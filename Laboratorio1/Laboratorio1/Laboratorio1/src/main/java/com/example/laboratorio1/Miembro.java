package com.example.laboratorio1;

import java.io.Serializable;
import java.util.ArrayList;

public class Miembro extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String correoElectronico;
    private TipoMiembro tipoMiembro;
    private ArrayList<Deporte> deportesRegistrados;

    public Miembro(String nombre, String id, String correoElectronico, TipoMiembro tipoMiembro) {
        super(nombre, id);
        this.correoElectronico = correoElectronico;
        this.tipoMiembro = tipoMiembro;
        this.deportesRegistrados = new ArrayList<>();
    }

    public void setDeportesRegistrados(ArrayList<Deporte> deportesRegistrados) {
        this.deportesRegistrados = deportesRegistrados;
    }

    public ArrayList<Deporte> getDeportesRegistrados() {
        return deportesRegistrados;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    public void RegistrarDeporte(Deporte deporte) {
        if (!deportesRegistrados.contains(deporte)) {
            deportesRegistrados.add(deporte);
        }
    }

    public static Miembro fromFileFormat(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) { // Asegúrate de que haya cuatro partes en la línea
            throw new IllegalArgumentException("Formato de línea no válido.");
        }
        String nombre = parts[0].trim();
        String id = parts[1].trim();
        String correoElectronico = parts[2].trim();
        TipoMiembro tipoMiembro = TipoMiembro.valueOf(parts[3].trim()); // Convierte la cadena a TipoMiembro

        return new Miembro(nombre, id, correoElectronico, tipoMiembro);
    }

    public String toFileFormat() {
        return getNombre() + "," + getId() + "," + correoElectronico + "," + tipoMiembro.name();
    }
}
