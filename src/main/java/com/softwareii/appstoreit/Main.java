package com.softwareii.appstoreit;

import com.softwareii.appstoreit.controller.LoginController;
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
}
