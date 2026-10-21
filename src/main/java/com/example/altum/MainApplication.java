package com.example.altum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Locale locale = Locale.forLanguageTag("en-EN");
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages",locale);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"),bundle);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Altum");
        stage.setScene(scene);
        stage.show();
        stage.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}