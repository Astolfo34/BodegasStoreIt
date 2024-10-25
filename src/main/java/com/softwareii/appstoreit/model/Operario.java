package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Operario {
    public ArrayList<Mercancia>mercanciasAsignadas;
    private String nombre;
    private int id;
    private boolean disponible;


    public Operario(String nombre, int id, boolean disponible) {
        this.nombre = nombre;
        this.id = id;
        this.disponible = disponible;
    }
    public Operario() {
    }
    public ArrayList<Mercancia> getListaMercancias() {
        return mercanciasAsignadas;
    }

    public void setListaMercancias(ArrayList<Mercancia> listaMercancias) {
        this.mercanciasAsignadas = listaMercancias;
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
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
