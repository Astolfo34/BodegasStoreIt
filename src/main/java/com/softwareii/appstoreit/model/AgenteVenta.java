package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class AgenteVenta {
    public ArrayList<Venta>listaVentas=new ArrayList<Venta>();
    private String nompre;
    private int id;

    public AgenteVenta(String nompre, int id) {
        this.nompre = nompre;
        this.id = id;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public String getNompre() {
        return nompre;
    }

    public void setNompre(String nompre) {
        this.nompre = nompre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
