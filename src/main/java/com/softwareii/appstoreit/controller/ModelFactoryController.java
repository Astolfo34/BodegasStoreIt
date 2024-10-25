package com.softwareii.appstoreit.controller;
import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Mercancia;
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


    public void actualizarUsuario(Usuario usuarioAActualizar) {
        bodega.actualizarUsuario(usuarioAActualizar);
        try{
            ArchivoUtil.salvarRecursoSerializadoXML(Persistencia.USUARIOS,bodega);
        } catch (IOException e){ e.printStackTrace(); }
    }
    public Mercancia buscarMercanciaEnBodega(Mercancia mercanciaBuscada) {
        Mercancia resultado = new Mercancia();
        //System.out.println("nombre: "+mercanciaBuscada.getNombre());  System.out.println("id: "+mercanciaBuscada.getId());
        for(Mercancia aux : bodega.getListaMercanciasBodega()){
            if(aux.getNombre().equals(mercanciaBuscada.getNombre()) || aux.getId()==mercanciaBuscada.getId()){
                resultado = aux; break;
            }
        }
        return resultado;
    }
    public void agregarMercancia(Mercancia mercanciaAcrear) {
        bodega.agregarMercancia(mercanciaAcrear,bodega.getListaMercanciasBodega());
    }
    public void actualizarMercanciaEnModelo(Mercancia mercanciaParaActualizar) {
        bodega.actualizarMercancia(mercanciaParaActualizar);

    }
    public void eliminarMercancia(int idMercanciParaBorrar) {
        bodega.eliminarMercancia(idMercanciParaBorrar,bodega.getListaMercanciasBodega());
    }

    public static String ORGANIZAR_TO_STRING(String entrada) {

        // Elimina los corchetes exteriores y separa los atributos por coma y espacio ", "
        String contenido = entrada.substring(entrada.indexOf("{") + 1, entrada.lastIndexOf("}"));
        StringBuilder resultado = new StringBuilder();

        // Dividir por las comas que separan cada atributo
        String[] atributos = contenido.split(", ");

        // Formatear cada atributo en filas con ":"
        for (String atributo : atributos) {
            // Dividir cada atributo en clave y valor por el "="
            String[] claveValor = atributo.split("=", 2);

            // Alinear el nombre del campo a la izquierda para mantener uniformidad
            resultado.append(String.format("%-15s: %s%n", claveValor[0], claveValor[1]));
        }

        return resultado.toString();
    }

}
