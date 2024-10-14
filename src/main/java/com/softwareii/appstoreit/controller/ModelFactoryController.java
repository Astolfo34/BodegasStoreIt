package com.softwareii.appstoreit.controller;
import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Usuario;
import com.softwareii.appstoreit.utils.ArchivoUtil;
import com.softwareii.appstoreit.utils.Persistencia;

import java.io.IOException;

public class ModelFactoryController {

    Bodega bodega;


    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        try {
            bodega = (Bodega) ArchivoUtil.cargarRecursoSerializadoXML(Persistencia.USUARIOS);
        } catch (Exception e) {
            bodega = new Bodega();
        }
    }

    public boolean verificarUsuario(Usuario usuario) {
        return bodega.getListaUsuariosPlataformaBodega().contains(usuario);
    }

    public boolean verificarExistenciaUsuario(Usuario usuario) {
        return bodega.getListaUsuariosPlataformaBodega().contains(usuario);
    }

    public void agregarUsuario(Usuario usuario) {
        bodega.getListaUsuariosPlataformaBodega().add(usuario);
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(Persistencia.USUARIOS, bodega);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
