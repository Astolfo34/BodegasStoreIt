package com.softwareii.appstoreit.utils;

import com.softwareii.appstoreit.model.Venta;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ventas")
public class VentasWrapper {
    private List<Venta> ventas;

    @XmlElement(name = "venta")
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
