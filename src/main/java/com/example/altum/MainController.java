package com.example.altum;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML  private Label labelTitle;
    @FXML private TextField textfieldNumber1;
    @FXML private TextField textfieldNumber2;
    @FXML private ComboBox<String> comboboxOperation;
    @FXML private Button buttonCalculate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}