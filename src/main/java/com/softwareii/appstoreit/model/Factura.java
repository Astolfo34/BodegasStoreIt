package com.softwareii.appstoreit.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
@XmlRootElement
public class Factura {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double total;
    private String nombreMercancia;
    private String idMercancia; // String como tipo de dato
    private String dueñoMercancia;
    private String estadoMercancia;
    private Sector sectorAsignado; // Cambiado a Sector
    private Operario operarioAsignado; // Cambiado a Operario

    // Constructor por defecto
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(LocalDate fechaEntrada, LocalDate fechaSalida, double total,
                   String nombreMercancia, String idMercancia, String dueñoMercancia,
                   String estadoMercancia, Sector sectorAsignado, Operario operarioAsignado) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.total = total;
        this.nombreMercancia = nombreMercancia;
        this.idMercancia = idMercancia;
        this.dueñoMercancia = dueñoMercancia;
        this.estadoMercancia = estadoMercancia;
        this.sectorAsignado = sectorAsignado; // Cambiado a Sector
        this.operarioAsignado = operarioAsignado; // Cambiado a Operario
    }

    // Getters y setters
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreMercancia() {
        return nombreMercancia;
    }

    public void setNombreMercancia(String nombreMercancia) {
        this.nombreMercancia = nombreMercancia;
    }

    public String getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(String idMercancia) { // Cambiado a String
        this.idMercancia = idMercancia;
    }

    public String getDueñoMercancia() {
        return dueñoMercancia;
    }

    public void setDueñoMercancia(String dueñoMercancia) {
        this.dueñoMercancia = dueñoMercancia;
    }

    public String getEstadoMercancia() {
        return estadoMercancia;
    }

    public void setEstadoMercancia(String estadoMercancia) {
        this.estadoMercancia = estadoMercancia;
    }

    public Sector getSectorAsignado() {
        return sectorAsignado; // Cambiado a Sector
    }

    public void setSectorAsignado(Sector sectorAsignado) { // Cambiado a Sector
        this.sectorAsignado = sectorAsignado;
    }

    public Operario getOperarioAsignado() {
        return operarioAsignado; // Cambiado a Operario
    }

    public void setOperarioAsignado(Operario operarioAsignado) { // Cambiado a Operario
        this.operarioAsignado = operarioAsignado;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", total=" + total +
                ", nombreMercancia='" + nombreMercancia + '\'' +
                ", idMercancia='" + idMercancia + '\'' +
                ", dueñoMercancia='" + dueñoMercancia + '\'' +
                ", estadoMercancia='" + estadoMercancia + '\'' +
                ", sectorAsignado=" + sectorAsignado +
                ", operarioAsignado=" + operarioAsignado +
                '}';
    }
}