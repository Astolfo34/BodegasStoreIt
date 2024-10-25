package com.softwareii.appstoreit.controller;

import com.softwareii.appstoreit.model.Bodega;
import com.softwareii.appstoreit.model.Mercancia;
import com.softwareii.appstoreit.model.Operario;
import com.softwareii.appstoreit.model.Sector;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgenteVentasController {
    private Bodega bodega;

    @FXML
    private Button btnGenerarFactura;
    @FXML
    private TableView<Mercancia> tablaPendientes;
    @FXML
    private TableView<Mercancia> tablaFinalizadas;
    @FXML
    private TableColumn<Mercancia, String> columnaIdPendiente;
    @FXML
    private TableColumn<Mercancia, String> columnaNombrePendiente;
    @FXML
    private TableColumn<Mercancia, String> columnaDuenoPendiente;
    @FXML
    private TableColumn<Mercancia, String> columnaEstadoPendiente;

    @FXML
    private TableColumn<Mercancia, String> columnaIdFinalizada;
    @FXML
    private TableColumn<Mercancia, String> columnaNombreFinalizada;
    @FXML
    private TableColumn<Mercancia, String> columnaDuenoFinalizada;
    @FXML
    private TableColumn<Mercancia, String> columnaEstadoFinalizada;

    private ObservableList<Mercancia> mercanciasPendientes;
    private ObservableList<Mercancia> mercanciasFinalizadas;

    @FXML
    public void initialize() {
        // Obtener la instancia de bodega desde ModelFactoryController
        this.bodega = ModelFactoryController.getInstance().getBodega();

        mercanciasPendientes = FXCollections.observableArrayList();
        mercanciasFinalizadas = FXCollections.observableArrayList();

        tablaPendientes.setItems(mercanciasPendientes);
        tablaFinalizadas.setItems(mercanciasFinalizadas);

        // Definir las columnas
        columnaNombrePendiente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnaIdPendiente.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));
        columnaDuenoPendiente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDueño()));
        columnaEstadoPendiente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));

        columnaNombreFinalizada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnaIdFinalizada.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));
        columnaDuenoFinalizada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDueño()));
        columnaEstadoFinalizada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));

        // Cargar las mercancías desde la bodega
        cargarMercancias();
    }

    /**
     * Cargar las mercancías en las tablas a partir de la lista en la bodega.
     */
    private void cargarMercancias() {
        // Filtramos mercancías pendientes y finalizadas según su estado
        for (Mercancia mercancia : bodega.getListaMercanciasBodega()) {
            if (mercancia.getEstado().equals("Pendiente")) {
                mercanciasPendientes.add(mercancia);
            } else if (mercancia.getEstado().equals("Finalizado")) {
                mercanciasFinalizadas.add(mercancia);
            }
        }
    }

    @FXML
    public void asignarOperarioYSector() {
        // Obtener la mercancía seleccionada
        Mercancia seleccionada = tablaPendientes.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            // Crear diálogos de selección de Operario y Sector
            Operario operarioSeleccionado = seleccionarOperario();
            Sector sectorSeleccionado = seleccionarSector();

            // Verificar si se seleccionaron tanto el operario como el sector
            if (operarioSeleccionado != null && sectorSeleccionado != null) {
                // Asignar el operario y el sector a la mercancía seleccionada
                seleccionada.setOperarioAsignado(operarioSeleccionado);
                seleccionada.setSector(sectorSeleccionado);
                seleccionada.setEstado("Finalizado");

                // Actualizar las listas en la interfaz
                mercanciasPendientes.remove(seleccionada);
                mercanciasFinalizadas.add(seleccionada);

                // Actualizar la bodega (asumiendo que la mercancía ya está en la lista)
                bodega.actualizarMercancia(seleccionada);


                // Refrescar las tablas
                tablaPendientes.refresh();
                tablaFinalizadas.refresh();
            } else {
                mostrarError("Debe seleccionar un operario y un sector.");
            }
        } else {
            mostrarError("Seleccione una mercancía pendiente para asignar.");
        }
    }

    // Método para mostrar un diálogo para seleccionar el operario
    private Operario seleccionarOperario() {
        // Obtener lista de operarios disponibles
        List<Operario> operariosDisponibles = bodega.getListaOperariosBodega().stream()
                .filter(Operario::isDisponible)
                .collect(Collectors.toList());

        // Si no hay operarios disponibles, mostrar un error
        if (operariosDisponibles.isEmpty()) {
            mostrarError("No hay operarios disponibles.");
            return null;
        }

        // Crear el diálogo de selección de operarios
        ChoiceDialog<Operario> dialog = new ChoiceDialog<>(operariosDisponibles.get(0), operariosDisponibles);
        dialog.setTitle("Seleccionar Operario");
        dialog.setHeaderText("Seleccione un operario disponible");
        dialog.setContentText("Operario:");

        // Mostrar el diálogo y obtener el resultado
        Optional<Operario> result = dialog.showAndWait();
        return result.orElse(null); // Devolver el operario seleccionado o null si no se seleccionó nada
    }

    // Método para mostrar un diálogo para seleccionar el sector
    private Sector seleccionarSector() {
        // Obtener lista de sectores disponibles
        List<Sector> sectoresDisponibles = bodega.getListaSectoresBodega().stream()
                .filter(Sector::isDisponible)
                .collect(Collectors.toList());

        // Si no hay sectores disponibles, mostrar un error
        if (sectoresDisponibles.isEmpty()) {
            mostrarError("No hay sectores disponibles.");
            return null;
        }

        // Crear el diálogo de selección de sectores
        ChoiceDialog<Sector> dialog = new ChoiceDialog<>(sectoresDisponibles.get(0), sectoresDisponibles);
        dialog.setTitle("Seleccionar Sector");
        dialog.setHeaderText("Seleccione un sector disponible");
        dialog.setContentText("Sector:");

        // Mostrar el diálogo y obtener el resultado
        Optional<Sector> result = dialog.showAndWait();
        return result.orElse(null); // Devolver el sector seleccionado o null si no se seleccionó nada
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Métodos para buscar operario y sector (implementamos usando la clase Bodega)
    private Operario buscarOperarioDisponible() {
        for (Operario operario : bodega.getListaOperariosBodega()) {
            if (operario.isDisponible()) {
                return operario;
            }
        }
        return null;
    }

    private Sector buscarSectorDisponible() {
        for (Sector sector : bodega.getListaSectoresBodega()) {
            if (sector.isDisponible()) {
                return sector;
            }
        }
        return null;
    }

    @FXML
    void GenerarFactura(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com.softwareii.appstoreit.view/factura.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrar");
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}