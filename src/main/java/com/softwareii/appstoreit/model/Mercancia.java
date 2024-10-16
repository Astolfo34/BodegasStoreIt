package com.softwareii.appstoreit.model;

public class Mercancia {
    private String nombre;
    private int id;
    private String dueño;
    private Sector ubicacion;

    public Mercancia(String nombre, int id, String dueño, Sector ubicacion) {
        this.nombre = nombre;
        this.id = id;
        this.dueño = dueño;
        this.ubicacion = ubicacion;
    }

    public Mercancia() {

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

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public Sector getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Sector ubicacion) {
        this.ubicacion = ubicacion;
    }
}
