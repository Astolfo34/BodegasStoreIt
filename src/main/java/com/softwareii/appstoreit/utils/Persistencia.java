package com.softwareii.appstoreit.utils;

import com.softwareii.appstoreit.model.Factura;
import com.softwareii.appstoreit.model.Mercancia;
import com.softwareii.appstoreit.model.Usuario;
import com.softwareii.appstoreit.model.Venta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    /**
     * Direcciones de la persistencia
     */
    public static final String FACTURAS = "src/main/resources/com.softwareii.appstoreit.persistencia/facturas.xml";
    public static final String USUARIOS = "src/main/resources/com.softwareii.appstoreit.persistencia/usuarios.xml";
    public static final String MERCANCIAS = "src/main/resources/com.softwareii.appstoreit.persistencia/mercancias.xml";

    // Gestion de Usuarios
    public static void guardarUsuarios(List<Usuario> usuarios) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UsuariosWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        UsuariosWrapper wrapper = new UsuariosWrapper();
        wrapper.setUsuarios(usuarios);
        marshaller.marshal(wrapper, new File(USUARIOS));
    }

    // Método para cargar la lista de usuarios desde el archivo XML
    public static List<Usuario> cargarUsuarios() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UsuariosWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File(USUARIOS);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        UsuariosWrapper wrapper = (UsuariosWrapper) unmarshaller.unmarshal(file);
        return wrapper.getUsuarios();
    }

    // Clase interna para envolver la lista de usuarios esto es algo que requiere JAXB
    // Por que? no se toca investigar
    @XmlRootElement(name = "usuarios")
    public static class UsuariosWrapper {

        private List<Usuario> usuarios;

        @XmlElement(name = "usuario")
        public List<Usuario> getUsuarios() {
            return usuarios;
        }

        public void setUsuarios(List<Usuario> usuarios) {
            this.usuarios = usuarios;
        }
    }

    //Gestion de Mercancias
    public static void guardarMercancias(ArrayList<Mercancia> mercancias) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MercanciasWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        MercanciasWrapper wrapper = new MercanciasWrapper();
        wrapper.setMercancias(mercancias);
        marshaller.marshal(wrapper, new File(MERCANCIAS));
    }

    // Método para cargar mercancías desde el archivo XML
    public static ArrayList<Mercancia> cargarMercancias() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MercanciasWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File(MERCANCIAS);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        MercanciasWrapper wrapper = (MercanciasWrapper) unmarshaller.unmarshal(file);
        return wrapper.getMercancias();
    }

    // Clase interna para envolver la lista de mercancías
    @XmlRootElement(name = "mercancias")
    public static class MercanciasWrapper {

        private ArrayList<Mercancia> mercancias;

        @XmlElement(name = "mercancia")
        public ArrayList<Mercancia> getMercancias() {
            return mercancias;
        }

        public void setMercancias(ArrayList<Mercancia> mercancias) {
            this.mercancias = mercancias;
        }
    }

    public void guardarFactura(Factura factura) {
        // Implementa la lógica para guardar la factura en el archivo XML
        // Por ejemplo, podrías usar JAXB para la serialización a XML

        try {
            JAXBContext context = JAXBContext.newInstance(Factura.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File archivoFactura = new File(FACTURAS);
            if (!archivoFactura.exists()) {
                archivoFactura.createNewFile();
            }

            marshaller.marshal(factura, archivoFactura);
        } catch (JAXBException | IOException e) {
            e.printStackTrace(); // Maneja excepciones según sea necesario
        }
    }
}

