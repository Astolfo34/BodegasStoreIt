package com.softwareii.appstoreit.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import com.softwareii.appstoreit.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SignUpController {
    private ModelFactoryController modelFactoryController;


    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Hyperlink linkLogin;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        String nombre = txtNombre.getText();
        String id = txtID.getText();
        String username = txtUsuario.getText();
        String password = txtContraseña.getText();

        if (nombre.isEmpty() || id.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Campos Vacíos", "Por favor, complete todos los campos.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(username, password);

        if (!modelFactoryController.verificarExistenciaUsuario(nuevoUsuario)) {
            modelFactoryController.agregarUsuario(nuevoUsuario);
            showAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", "¡Usuario registrado con éxito!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Error al guardar el usuario en el archivo.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
