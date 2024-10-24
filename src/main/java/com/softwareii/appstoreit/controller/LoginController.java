package com.softwareii.appstoreit.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.softwareii.appstoreit.Main;
import com.softwareii.appstoreit.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class LoginController {

    public void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;

    private ModelFactoryController modelFactoryController;



    @FXML
    void iniciarSesion(ActionEvent event) {
        String username = txtUsuario.getText();
        String password = txtContrasena.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Campos Vacíos", "Por favor, complete todos los campos.");
            return;
        }

        Usuario usuario = new Usuario(username, password);

        if (modelFactoryController.verificarUsuario(usuario)) {
            showAlert(Alert.AlertType.INFORMATION, "Inicio Exitoso", "¡Bienvenido!");
            abrirVentanaUsuario();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Error al iniciar sesion.");
        }
    }

    private void abrirVentanaUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com.softwareii.appstoreit.view/vistaPrueba.fxml"));
            Parent root =(Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("vista de usuario");
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void irARegistrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com.softwareii.appstoreit.view/singUpView.fxml"));
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
