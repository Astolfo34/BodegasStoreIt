package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Operario {
    public ArrayList<Mercancia>listaMercancias=new ArrayList<Mercancia>();
    private String nombre;
    private int id;

    public Operario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
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
}
