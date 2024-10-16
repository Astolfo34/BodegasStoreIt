package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Venta {
    private String fecha;
    private int id;
    private Object informeVenta;

    public Venta(String fecha, int id, Object informeVenta) {
        this.fecha = fecha;
        this.id = id;
        this.informeVenta = informeVenta;
    }

    public Venta() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getInformeVenta() {
        return informeVenta;
    }

    public void setInformeVenta(Object informeVenta) {
        this.informeVenta = informeVenta;
    }
}
