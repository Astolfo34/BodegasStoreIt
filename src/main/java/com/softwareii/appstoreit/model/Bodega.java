package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Bodega {
    //----------atributos de la clase principal pertenecientes al universo de la empresa StoreIt
    private ArrayList<Sector>listaSectoresBodega = new ArrayList<Sector>();
    private ArrayList<Cliente>listaClientesBodega = new ArrayList<Cliente>();
    private ArrayList<Operario>listaOperariosBodega = new ArrayList<Operario>();
    private ArrayList<AgenteVenta>listaAgentesVentasBodega = new ArrayList<AgenteVenta>();
    private ArrayList<Mercancia>listaMercanciasBodega = new ArrayList<Mercancia>();
    private ArrayList<Venta>listaVentasBodega = new ArrayList<Venta>();
    private ArrayList<Usuario>listaUsuariosPlataformaBodega= new ArrayList<Usuario>();
    private String nombreBodega;
    private int id;
    //----------------------{constructor principal}----------------------------------

    public Bodega(ArrayList<Sector> listaSectoresBodega, ArrayList<Cliente> listaClientesBodega,
                  ArrayList<Operario> listaOperariosBodega, ArrayList<AgenteVenta> listaAgentesVentasBodega,
                  ArrayList<Mercancia> listaMercanciasBodega, ArrayList<Venta> listaVentasBodega,
                  ArrayList<Usuario> listaUsuariosPlataformaBodega, String nombreBodega, int id) {

        this.listaSectoresBodega = listaSectoresBodega;
        this.listaClientesBodega = listaClientesBodega;
        this.listaOperariosBodega = listaOperariosBodega;
        this.listaAgentesVentasBodega = listaAgentesVentasBodega;
        this.listaMercanciasBodega = listaMercanciasBodega;
        this.listaVentasBodega = listaVentasBodega;
        this.listaUsuariosPlataformaBodega = listaUsuariosPlataformaBodega;
        this.nombreBodega = nombreBodega;
        this.id = id;
    }

    /**
     * CONSTRUCTOR VACIO------------------------------------------------------------------------{
     */
    public Bodega() {
    }

    /**
     *-----------------------------------------------------------------------------------------}
     */
    //-----------------------{metodos getter y setter}------------------------------------------

    public ArrayList<Sector> getListaSectoresBodega() {
        return listaSectoresBodega;
    }

    public void setListaSectoresBodega(ArrayList<Sector> listaSectoresBodega) {
        this.listaSectoresBodega = listaSectoresBodega;
    }

    public ArrayList<Cliente> getListaClientesBodega() {
        return listaClientesBodega;
    }

    public void setListaClientesBodega(ArrayList<Cliente> listaClientesBodega) {
        this.listaClientesBodega = listaClientesBodega;
    }

    public ArrayList<Operario> getListaOperariosBodega() {
        return listaOperariosBodega;
    }

    public void setListaOperariosBodega(ArrayList<Operario> listaOperariosBodega) {
        this.listaOperariosBodega = listaOperariosBodega;
    }

    public ArrayList<AgenteVenta> getListaAgentesVentasBodega() {
        return listaAgentesVentasBodega;
    }

    public void setListaAgentesVentasBodega(ArrayList<AgenteVenta> listaAgentesVentasBodega) {
        this.listaAgentesVentasBodega = listaAgentesVentasBodega;
    }

    public ArrayList<Mercancia> getListaMercanciasBodega() {
        return listaMercanciasBodega;
    }

    public void setListaMercanciasBodega(ArrayList<Mercancia> listaMercanciasBodega) {
        this.listaMercanciasBodega = listaMercanciasBodega;
    }

    public ArrayList<Venta> getListaVentasBodega() {
        return listaVentasBodega;
    }

    public void setListaVentasBodega(ArrayList<Venta> listaVentasBodega) {
        this.listaVentasBodega = listaVentasBodega;
    }

    public ArrayList<Usuario> getListaUsuariosPlataformaBodega() {
        return listaUsuariosPlataformaBodega;
    }

    public void setListaUsuariosPlataformaBodega(ArrayList<Usuario> listaUsuariosPlataformaBodega) {
        this.listaUsuariosPlataformaBodega = listaUsuariosPlataformaBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
