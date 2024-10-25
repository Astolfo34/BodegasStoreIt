package com.softwareii.appstoreit.model;

public class Mercancia {
    private String nombre;
    private int id;
    private String dueño;
    private String estado;
    private Sector sectorAsignado;
    private Operario operarioAsignado;


    public Mercancia(String nombre, int id, String dueño, Sector ubicacion) {
        this.nombre = nombre;
        this.id = id;
        this.dueño = dueño;
        this.sectorAsignado = ubicacion;
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

    public Sector getSectorAsignado() {
        return sectorAsignado;
    }

    public void setSector(Sector sectorAsignado) {
        this.sectorAsignado = sectorAsignado;
    }



    public Operario getOperarioAsignado() {
        return operarioAsignado;
    }

    public void setOperarioAsignado(Operario operarioAsignado) {
        this.operarioAsignado = operarioAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
