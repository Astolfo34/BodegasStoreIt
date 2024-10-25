package com.softwareii.appstoreit.controller;
import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Usuario;
import com.softwareii.appstoreit.utils.ArchivoUtil;
import com.softwareii.appstoreit.utils.Persistencia;
import com.softwareii.appstoreit.utils.StoreItUtils;

import javax.xml.bind.JAXBException;
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
            bodega = new Bodega();
            bodega.setListaMercanciasBodega(Persistencia.cargarMercancias());  // Carga mercancías desde XML
            bodega = StoreItUtils.inicializarDatos();  // Sobrescribe la bodega, posiblemente vacía
            System.out.println("Mercancías cargadas: " + bodega.getListaMercanciasBodega().size());
        } catch (Exception e) {
            e.printStackTrace();
            bodega = new Bodega();
        }
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void agregarUsuario(Usuario usuario) {
        bodega.getListaUsuariosPlataformaBodega().add(usuario);
        try {
            Persistencia.guardarUsuarios(bodega.getListaUsuariosPlataformaBodega());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarUsuario(Usuario usuario) {
        return bodega.getListaUsuariosPlataformaBodega().contains(usuario);
    }

    public boolean verificarExistenciaUsuario(Usuario usuario) {
        return bodega.getListaUsuariosPlataformaBodega().contains(usuario);
    }


}
