package com.softwareii.appstoreit.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------atributos de la clase principal pertenecientes al universo de la empresa StoreIt
    public ArrayList<Sector>listaSectoresBodega = new ArrayList<Sector>();
    public ArrayList<Cliente>listaClientesBodega = new ArrayList<Cliente>();
    public ArrayList<Operario>listaOperariosBodega = new ArrayList<Operario>();
    public ArrayList<AgenteVenta>listaAgentesVentasBodega = new ArrayList<AgenteVenta>();
    public ArrayList<Mercancia>listaMercanciasBodega = new ArrayList<Mercancia>();
    public ArrayList<Venta>listaVentasBodega = new ArrayList<Venta>();
    public ArrayList<Usuario>listaUsuariosPlataformaBodega= new ArrayList<Usuario>();
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
    //-----------------------{metodos getter y setter}------------------------------------------{

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
    /**
     * ----------------------------------------------------------------------------------------------------}
     */


    /**
     * ------------------------------METODOS CRUD --------------------------------------------{
     */
    /**
     * Este metodo debe recibir un objeto de tipo cliente capturado de la vista
     * el cual se analisa si existe en la base de datos , y si es nuevo se añade
     * @param clienteNuevo
     * @return
     */
    public Cliente crearCliente (Cliente clienteNuevo){
        if(!verificarExistencia(clienteNuevo,listaClientesBodega)){ //el metodo interno retorna true o false
            listaClientesBodega.add(clienteNuevo);
        }else{
            System.out.println("###########el cliente ya existe, no se puede crear################");
        }
        return null;
    }

    /**
     * Metodo que recibe un objeto cliente capturado de la vista, para ser eliminado
     * @param clienteA_eliminar
     */
    public void eliminarCliente(Cliente clienteA_eliminar){
        if(eliminarObjeto(clienteA_eliminar,listaClientesBodega)){
            System.out.println("cliente : "+clienteA_eliminar.getNombre()+" a sido eliminado");
        }else{
            System.out.println("el cliente no se pudo remover");
        }
    }

    /**
     * Metodo que recibe un nuevo objeto capturado que comparte el id del cliente
     * para ser comparado con el objeto real en a lista, eliminarlo, y agregar el nuevo objeto
     * @param clienteActualizado
     */
    public void actualizarCliente(Cliente clienteActualizado){
        for (Cliente aux:listaClientesBodega) {
            if(aux.getId()==clienteActualizado.getId()){
                eliminarObjeto(aux,listaClientesBodega);
                crearCliente(clienteActualizado);
                break;
            }
        }
    }

    /**
     * Metodo generico que comprueba si una lista posee un elemento , si lo tiene retorna un TRUE
     * @param objetoPreguntado
     * @param listaAbuscar
     * @return
     * @param <K>
     */
    public static  <K> boolean verificarExistencia(K objetoPreguntado,ArrayList<K> listaAbuscar) {
        return listaAbuscar.contains(objetoPreguntado);
    }

    /**
     * Metodo generico que dado un objeto y una lista correspondiente, elimina y da como resultado true
     * @param elementoA_borrar
     * @param listaAborrar
     * @return
     * @param <K>
     */
    public static  <K> boolean eliminarObjeto(K elementoA_borrar, ArrayList<K> listaAborrar){
        return listaAborrar.remove(elementoA_borrar);
    }
    //-----------------------CRUD DE SECTORES-----------------------------------------

    /**
     * METODO ENCARGADO DE CREAR SECTORES DONDE SE GUADARAN LAS MERCANCIAS DE LOS CLIENTES
     * @param nuevoSector
     * @param listaSectores
     * @return
     */
    public boolean agregarSector(Sector nuevoSector, ArrayList<Sector>listaSectores){
        boolean flag=false;
        if(!verificarExistencia(nuevoSector,listaSectores)){
            this.listaSectoresBodega.add(nuevoSector);
            flag=true;
        }else{ System.out.println("el sector ya existe, no se puede volver a crear");}
        return flag;
    }

    /**
     * METODO ENCARGADO DE ELIMINAR LOS SECTORES DE LA LISTA DE SECTORES
     * @param id
     * @param listaSectores
     */
    public void eliminarSector(int id, ArrayList<Sector>listaSectores){
        for (Sector aux:listaSectores) {
            if(aux.getId()==id){ listaSectores.remove(aux);}
            else{ System.out.println("el sector a eliminar no existe");}
        }
    }

    /**
     * METODO ENCARGADO DE OBTENER UNA INSTANCIA DE UN SECTOR DE LA LISTA DE SECTORES
     * SEGUN UN ID RECIBIDO
     * @param id
     * @param listaSectores
     * @return
     */
    public Sector obtenerSector(int id, ArrayList<Sector>listaSectores){
        Sector sectorBuscado = new Sector();
        for(Sector aux : listaSectores ){
            if (aux.getId()==id){ sectorBuscado = aux; break ;}
        }
        return sectorBuscado;
    }
    public void actualizarSector(Sector sectorActualizado){
        for (Sector aux:listaSectoresBodega) {
            if(aux.getId()==sectorActualizado.getId()){
                eliminarObjeto(aux,listaSectoresBodega);
                agregarSector(sectorActualizado,listaSectoresBodega);
                break;
            }
        }
    }
}
