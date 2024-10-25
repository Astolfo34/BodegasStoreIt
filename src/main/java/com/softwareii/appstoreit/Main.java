package com.softwareii.appstoreit;

import com.softwareii.appstoreit.controller.LoginController;
import com.softwareii.appstoreit.controller.UserViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    public void start(Stage stage) {
        try {
            this.primaryStage = stage;
            this.primaryStage.setTitle("Store-It");
            mostrarVentanaPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com.softwareii.appstoreit.view/loginView.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            LoginController loginController = loader.getController();
            loginController.setApplication(this); // envio el ecenario para ser administrado desde otro controller
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Main() {
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void abrirVentanaUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com.softwareii.appstoreit.view/vistaPrueba.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UserViewController controlleraux = loader.getController();
            controlleraux.setApplication(this); // envio el ecenario para ser administrado desde otro controller
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
