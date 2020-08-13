package com.bartduisters;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PixelPicker extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-ui.fxml"));
        primaryStage.setTitle("Pixel Picker");
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.show();
    }
}
