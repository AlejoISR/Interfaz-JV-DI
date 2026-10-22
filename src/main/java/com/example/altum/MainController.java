package com.example.altum;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.Theme;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private Label labelResult;
    @FXML private Label labelTitle;
    @FXML private TextField textfieldNumber1, textfieldNumber2;
    @FXML private ComboBox<Option> comboboxOperation, comboBoxTheme, comboboxThere;
    @FXML private Button buttonCalculate;


    private void checkValues(){
        boolean validCombo = comboboxOperation.getValue() != null;
        boolean validTexfield = false;

        try {
            int n1 = Integer.parseInt(textfieldNumber1.getText());
            int n2 = Integer.parseInt(textfieldNumber2.getText());

            if (validCombo && "divide".equals(comboboxOperation.getValue().getKey()) && n2 == 0) {
                validTexfield = false;
            } else {
                validTexfield = true;
            }
        } catch (Exception error){

        }
        buttonCalculate.setDisable(!(validCombo && validTexfield));
    }


    private ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;

        Option optionAdd       = new Option("add",       bundle.getString("option.add"));
        Option optionSubtract  = new Option("substract", bundle.getString("option.substract"));
        Option optionMultiply  = new Option("multiply",  bundle.getString("option.multiply"));
        Option optionDivide    = new Option("divide",    bundle.getString("option.divide"));



        Option optionTheme1 = new Option("theme1", "CupertinoLight");
        Option optionTheme2 = new Option("theme2", "CupertinoDark");
        Option optionTheme3 = new Option("theme3", "Dracula");
        if (comboBoxTheme == null) {
            comboBoxTheme = comboboxThere;
        }
        comboBoxTheme.getItems().addAll(optionTheme1, optionTheme2, optionTheme3);
        comboBoxTheme.valueProperty().addListener(_ -> {
            Option newOption = comboBoxTheme.getValue();
            if (newOption == null) return;
            Theme newTheme = switch (newOption.getKey()) {
                case "theme1" -> new CupertinoLight();
                case "theme2" -> new CupertinoDark();
                case "theme3" -> new Dracula();
                default -> null;
            };
            if (newTheme != null) {
                Application.setUserAgentStylesheet(newTheme.getUserAgentStylesheet());
            }
        });


        labelTitle.requestFocus();
        comboboxOperation.getItems().addAll(optionAdd, optionSubtract, optionMultiply, optionDivide);

        // Escuchadores pendientes de cambio

        textfieldNumber1.textProperty().addListener(_ -> checkValues());
        textfieldNumber2.textProperty().addListener(_ -> checkValues());
        comboboxOperation.valueProperty().addListener(_ -> checkValues());

        buttonCalculate.setOnAction(_ -> {

            int numero1 = Integer.parseInt(textfieldNumber1.getText());
            int numero2 = Integer.parseInt(textfieldNumber2.getText());
            String operacion = comboboxOperation.getValue().getKey();

            int resueltado = switch (operacion) {
                case "add"       -> numero1 + numero2;
                case "substract" -> numero1 - numero2;
                case "multiply"  -> numero1 * numero2;
                case "divide"    -> numero1 / numero2;
                default -> 0;
            };

            labelResult.setText(MessageFormat.format(bundle.getString("label.result"), resueltado));
        });
    }
}