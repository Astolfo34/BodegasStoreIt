package com.softwareii.appstoreit.model;

public class Cliente {
    //-----------------------ATRIBUTOS------------------------------------
    private String nombre;
    private int id;
    private Usuario cuentaUsuario;

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
    //-------------------METODOS CRUD DE MERCANCIA---------------------

}
