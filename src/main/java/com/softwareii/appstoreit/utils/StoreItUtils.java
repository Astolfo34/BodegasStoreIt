package com.softwareii.appstoreit.utils;

import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Mercancia;
import com.softwareii.appstoreit.model.Operario;
import com.softwareii.appstoreit.model.Sector;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class StoreItUtils {
    public static Bodega inicializarDatos() throws JAXBException {
        Bodega bodega = new Bodega();

        // Crear operarios por defecto
        Operario operario1 = new Operario("Operario 1", 1, true);
        Operario operario2 = new Operario("Operario 2", 2, true);
        Operario operario3 = new Operario("Operario 3", 3, true);

        // Agregar operarios a la lista
        bodega.getListaOperariosBodega().add(operario1);
        bodega.getListaOperariosBodega().add(operario2);
        bodega.getListaOperariosBodega().add(operario3);

        // Crear sectores por defecto
        Sector sector1 = new Sector("Sector 1", 1, 10, true);
        Sector sector2 = new Sector("Sector 2", 2, 15, true);
        Sector sector3 = new Sector("Sector 3", 3, 20, true);

        // Agregar sectores a la lista
        bodega.getListaSectoresBodega().add(sector1);
        bodega.getListaSectoresBodega().add(sector2);
        bodega.getListaSectoresBodega().add(sector3);

        // Crear mercancías por defecto
        ArrayList<Mercancia> mercancias = Persistencia.cargarMercancias();  // Asegúrate de que este método está funcionando bien.

        if (mercancias != null && !mercancias.isEmpty()) {
            bodega.setListaMercanciasBodega(mercancias);
        } else {
            System.out.println("No se cargaron mercancías desde el archivo XML.");
        }

        return bodega;
    }
}
