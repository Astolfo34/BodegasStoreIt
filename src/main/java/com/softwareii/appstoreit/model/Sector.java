package com.softwareii.appstoreit.model;

import java.util.ArrayList;
import java.util.List;


public class Sector {
    private List<Mercancia> mercancias; // Cambiar el nombre aquí
    private String nombre;
    private int id;
    private int cupo;
    private boolean disponible;

    public Sector(String nombre, int id, int cupo, boolean disponible) {
        this.nombre = nombre;
        this.id = id;
        this.cupo = cupo;
        this.disponible = disponible;
        this.mercancias = new ArrayList<>(); // Inicializa la lista
    }

    public Sector() {
        this.mercancias = new ArrayList<>(); // Inicializa la lista en el constructor por defecto
    }

    public List<Mercancia> getMercancias() { // Cambiar el nombre aquí
        return mercancias;
    }

    public void setMercancias(ArrayList<Mercancia> mercancias) { // Cambiar el nombre aquí
        this.mercancias = mercancias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Sector{" +
                "listaMercancias=" + mercancias +
                ", nombre Sector='" + nombre + '\'' +
                ", id del sector=" + id +
                ", cupo del sector =" + cupo +
                '}';
    }
}
