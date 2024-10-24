package com.softwareii.appstoreit.model;

public class Mercancia {
    private String nombre;
    private int id;
    private String dueño;
    private Sector ubicacion;
    private String fecha;

    public Mercancia(String nombre, int id, String dueño, Sector ubicacion, String fecha) {
        this.nombre = nombre;
        this.id = id;
        this.dueño = dueño;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
