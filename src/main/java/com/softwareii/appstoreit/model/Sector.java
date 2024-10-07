package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Sector {
    public ArrayList<Mercancia>listaMercancias=new ArrayList<Mercancia>();
    private String nombre;
    private int id;
    private int cupo;

    public Sector(String nombre, int id, int cupo) {
        this.nombre = nombre;
        this.id = id;
        this.cupo = cupo;
    }

    public ArrayList<Mercancia> getListaMercancias() {
        return listaMercancias;
    }

    public void setListaMercancias(ArrayList<Mercancia> listaMercancias) {
        this.listaMercancias = listaMercancias;
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
}
