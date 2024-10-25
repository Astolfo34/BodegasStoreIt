package com.softwareii.appstoreit.controller;

import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Factura;
import com.softwareii.appstoreit.model.Mercancia;
import com.softwareii.appstoreit.model.Venta;
import com.softwareii.appstoreit.utils.Persistencia;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FacturaController {
    @FXML
    private ListView<Mercancia> mercanciasListView;

    @FXML
    private Label totalLabel;

    @FXML
    private DatePicker entradaDatePicker;

    @FXML
    private DatePicker salidaDatePicker;

    @FXML
    private Button generarFactura;

    private Bodega bodega;

    public FacturaController() {
        // No inicialices aquí, porque mercanciasListView no está disponible aún
        // bodega = ModelFactoryController.getInstance().getBodega();
    }

    @FXML
    public void initialize() {
        // Inicializa la bodega y carga las mercancías
        bodega = ModelFactoryController.getInstance().getBodega();
        cargarMercanciasFinalizadas(); // Cargar las mercancías finalizadas directamente
    }

    private void cargarMercanciasFinalizadas() {
        List<Mercancia> mercanciasFinalizadas = new ArrayList<>();
        for (Mercancia mercancia : bodega.getListaMercanciasBodega()) {
            if (mercancia.getEstado().equalsIgnoreCase("finalizado")) {
                mercanciasFinalizadas.add(mercancia);
            }
        }
        mercanciasListView.getItems().addAll(mercanciasFinalizadas);
        calcularTotal(mercanciasFinalizadas);
    }

    private void calcularTotal(List<Mercancia> mercancias) {
        int totalSemanas = (int) mercancias.size() / 7; // Supongamos que cada mercancía representa una semana
        int total = totalSemanas * 150; // $150 por semana
        totalLabel.setText("Total: $" + total);
    }

    private Mercancia obtenerMercanciaSeleccionada() {
        return mercanciasListView.getSelectionModel().getSelectedItem(); // Obtiene la mercancía seleccionada
    }

    @FXML
    private void generarFactura() {
        LocalDate fechaEntrada = entradaDatePicker.getValue();
        LocalDate fechaSalida = salidaDatePicker.getValue();

        if (fechaEntrada != null && fechaSalida != null) {
            long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
            double total = dias * 20; // $20 por día
            totalLabel.setText("Total: $" + total);

            // Obtén la mercancía seleccionada
            Mercancia mercanciaSeleccionada = obtenerMercanciaSeleccionada();
            if (mercanciaSeleccionada != null) {
                // Crea la factura con todos los detalles
                Factura factura = new Factura(fechaEntrada, fechaSalida, total,
                        mercanciaSeleccionada.getNombre(),
                        String.valueOf(mercanciaSeleccionada.getId()), // Convertir a String
                        mercanciaSeleccionada.getDueño(),
                        mercanciaSeleccionada.getEstado(),
                        mercanciaSeleccionada.getSectorAsignado(),
                        mercanciaSeleccionada.getOperarioAsignado());

                // Guarda la factura usando la clase Persistencia
                Persistencia persistencia = new Persistencia();
                persistencia.guardarFactura(factura); // Implementa este método en la clase Persistencia
            } else {
                // Maneja el caso en que no hay mercancía seleccionada
                System.out.println("No se ha seleccionado ninguna mercancía.");
            }
        } else {
            totalLabel.setText("Total: $0"); // Manejar el caso donde las fechas no están seleccionadas
        }
    }
}