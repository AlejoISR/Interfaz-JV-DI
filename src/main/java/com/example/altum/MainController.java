package com.example.altum;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private Label labelResult;
    @FXML private Label labelTitle;
    @FXML private TextField textfieldNumber1, textfieldNumber2;
    @FXML private ComboBox<String> comboboxOperation;
    @FXML private Button buttonCalculate;


    private void checkValues(){
        boolean validCombo = comboboxOperation.getValue() !=null;
        boolean validTexfield = false;

        try {
            Integer.parseInt(textfieldNumber1.getText());
            Integer.parseInt(textfieldNumber2.getText());

            validTexfield = true;
        } catch (Exception error){

        }
        buttonCalculate.setDisable(!(validCombo && validTexfield));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelTitle.requestFocus();
        comboboxOperation.getItems().addAll("Sumar","Restar","Multiplicar","Dividir");



        // Escuchadores pendientes de cambio

        textfieldNumber1.textProperty().addListener(_-> checkValues());
        textfieldNumber2.textProperty().addListener(_-> checkValues());
        comboboxOperation.valueProperty().addListener(_-> checkValues());

        buttonCalculate.setOnAction(_->{

            int numero1 = Integer.parseInt(textfieldNumber1.getText());
            int numero2 = Integer.parseInt(textfieldNumber2.getText());
            String operacion = comboboxOperation.getValue();

            int resueltado = switch (operacion){
              case "Sumar"   -> numero1+numero2;
              case "Restar" -> numero1-numero2;
              case "Multiplicar" -> numero1*numero2;
              case "Dividir" -> numero1/numero2;
                default -> 0;
            };

            labelResult.setText(String.valueOf(resueltado));
        });
    }
}