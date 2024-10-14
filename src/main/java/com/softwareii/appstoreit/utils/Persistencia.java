package com.softwareii.appstoreit.utils;

import com.softwareii.appstoreit.model.Usuario;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    /**
     * Direcciones de la persistencia
     */
    public static final String FACTURAS = "src/main/resources/com.softwareii.appstoreit.persistencia/facturas.xml";
    public static final String USUARIOS = "src/main/resources/com.softwareii.appstoreit.persistencia/usuarios.xml";

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
}

