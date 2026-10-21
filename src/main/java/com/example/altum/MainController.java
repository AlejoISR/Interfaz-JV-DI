package com.example.altum;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.text.MaskFormatter;
import java.lang.classfile.Opcode;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private Label labelResult;
    @FXML private Label labelTitle;
    @FXML private TextField textfieldNumber1, textfieldNumber2;
    @FXML private ComboBox<Option> comboboxOperation;
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


    private  ResourceBundle bundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;

        Option optionAdd       = new Option("add",               bundle.getString("option.add"));
        Option optionSubtract  = new Option("substract",         bundle.getString("option.substract"));
        Option optionMultiply  = new Option("multiply",      bundle.getString("option.multiply"));
        Option optionDivide    = new Option("divide",          bundle.getString("option.divide"));



        labelTitle.requestFocus();
        comboboxOperation.getItems().addAll(optionAdd,optionSubtract,optionMultiply,optionDivide);

        // Escuchadores pendientes de cambio

        textfieldNumber1.textProperty().addListener(_-> checkValues());
        textfieldNumber2.textProperty().addListener(_-> checkValues());
        comboboxOperation.valueProperty().addListener(_-> checkValues());

        buttonCalculate.setOnAction(_->{

            int numero1 = Integer.parseInt(textfieldNumber1.getText());
            int numero2 = Integer.parseInt(textfieldNumber2.getText());
            String operacion = comboboxOperation.getValue().getKey();

            int resueltado = switch (operacion){
              case "add"   -> numero1+numero2;
              case "substract" -> numero1-numero2;
              case "multiply" -> numero1*numero2;
              case "divide" -> numero1/numero2;
                default -> 0;
            };

            labelResult.setText(MessageFormat.format(bundle.getString("label.result"),resueltado));
        });
    }
}