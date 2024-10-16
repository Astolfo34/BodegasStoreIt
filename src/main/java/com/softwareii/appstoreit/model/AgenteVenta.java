package com.softwareii.appstoreit.model;

import java.util.ArrayList;
import com.softwareii.appstoreit.model.Bodega;

public class AgenteVenta {
    ArrayList<Venta>listaVentas=new ArrayList<Venta>();
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

    //----------------------CRUD DE VENTAS------------------------------------

    /**
     * METODO ENCARGADO DE VERIFICAR SI LA VENTA EXISTE EN LA LISTA DE VENTAS
     * Y DE NO SER ASI AGREHARLA A LA LISTA
     * @param nuevaVenta
     * @param listaVentas
     * @return
     */
    public boolean agregarVenta(Venta nuevaVenta, ArrayList<Venta> listaVentas){
        boolean flag=false;
        if(!Bodega.verificarExistencia(nuevaVenta,listaVentas)){
            listaVentas.add(nuevaVenta);
            flag=true;
        }else{ System.out.println("el id de la venta ya existe");}
        return flag;
    }

    /**
     * METODO ENCRAGADO DE RECIBIR UNA VENTA, BUSCARLA Y ELIMINARLA, SI SUI SE
     * ENCUENTRA...
     * @param id
     * @param listaVentas
     */
    public void eliminarVenta (int id, ArrayList<Venta>listaVentas){
        for (Venta aux:listaVentas) {
            if (aux.getId() == id) { Bodega.eliminarObjeto(aux,listaVentas);}
        }
    }

    /**
     * METODO PARA BUSCAR UNA VENTA POR SU ID
     * @param id
     * @param listaVentas
     * @return
     */
    public Venta obtenerVenta(int id, ArrayList<Venta>listaVentas){
        Venta ventaBuscada = new Venta();
        for (Venta aux:listaVentas) {
            if(aux.getId() == id) { ventaBuscada=aux;break;}
            else{ System.out.println("venta con el id :"+id+" no encontrada");}
        }
        return ventaBuscada;
    }

}
