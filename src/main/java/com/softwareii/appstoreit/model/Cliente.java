package com.softwareii.appstoreit.model;

import java.util.ArrayList;

public class Cliente {
    //-----------------------ATRIBUTOS------------------------------------
    private String nombre;
    private int id;
    private Usuario cuentaUsuario;
    ArrayList<Mercancia> mercancias=new ArrayList<>();

    public Cliente(String nombre, int id, Usuario cuentaUsuario) {
        this.nombre = nombre;
        this.id = id;
        this.cuentaUsuario = cuentaUsuario;
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

    public Usuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(Usuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
    /**
     * ----------------------CRUD MERCANCIA-------------------------{
     */
    /**
     * METODO QUE RECIBE UN OBJETO MERCANCIA PARA SER AGREGADO A LA LISTA DE LA CLASE
     * Y POSTERIOR A LA "BASE DE DATOS" DEL PROGRAMA CON EL PATRON MODELFACTORY
     * @param nuevaMercancia
     * @param listaMercancias
     * @return
     */
    public boolean agregarMercancia(Mercancia nuevaMercancia, ArrayList<Mercancia>listaMercancias) {
        boolean flag=false;
        if(!Bodega.verificarExistencia(nuevaMercancia, listaMercancias)){
            mercancias.add(nuevaMercancia);
            flag=true;
        }else{
            System.out.println("error al agregar la mercancia: "+nuevaMercancia.getNombre()+" , porque ya existe");
        }
        return flag;
    }

    /**
     * METODO QUE A APRTIR DE UN ID BUSCA EL OBJETO EN LA LISTA ENTREGADA PARA OBTENERLO Y ENVIARLO
     * @param id
     * @param listaMaercancias
     * @return
     */
    public Mercancia obtenerMercancia (int id,ArrayList<Mercancia>listaMaercancias){
        Mercancia mercanciaBuscada=new Mercancia();
        for (Mercancia aux : listaMaercancias) {
            if(aux.getId() == id) { mercanciaBuscada=aux;break; }
            else{ System.out.println("mercancia con id: " + id+", no encontrada"); }
        }
        return mercanciaBuscada;
    }

    /**
     * METODO QUE RECIBE COMO PARAMETRO EL ID
     * IDENTIFICADOR DE LA MERCANCIA, PARA BUSCARLO EN LA LISTA LOCAL Y ELIMINARLO
     * @param id
     * @param listaMercancias
     */
    public void eliminarMercancia (int id,ArrayList<Mercancia>listaMercancias){
        for (Mercancia aux:listaMercancias){
            if(aux.getId()==id){
                listaMercancias.remove(aux);
                break;
            }
        }
    }


}
