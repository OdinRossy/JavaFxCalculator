package com.glebremniov.javafxCalculator.controller;

import com.glebremniov.javafxCalculator.ArithmeticWorker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Controller {

    @FXML
    public Button btn0;
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    @FXML
    public Button btn6;
    @FXML
    public Button btn7;
    @FXML
    public Button btn8;
    @FXML
    public Button btn9;
    @FXML
    public Button buttonDot;
    @FXML
    public Button buttonAddition;
    @FXML
    public Button buttonSubtraction;
    @FXML
    public Button buttonMultiplication;
    @FXML
    public Button buttonDivision;
    @FXML
    public Button buttonEquality;
    @FXML
    public Button buttonClear;
    @FXML
    public Label labelResult;

    private boolean isActorA = true;
    private final ArithmeticWorker arithmeticWorker = new ArithmeticWorker();

    private final Font FONT_SMALL = new Font(26);
    private final Font FONT_MEDIUM = new Font(40);
    private final Font FONT_REGULAR = new Font(60);

    @FXML
    protected void initialize() {

        clearLabelResult();

        buttonAddition.setOnAction(event -> handleArithmeticAction('+'));
        buttonSubtraction.setOnAction(event -> handleArithmeticAction('-'));
        buttonMultiplication.setOnAction(event -> handleArithmeticAction('*'));
        buttonDivision.setOnAction(event -> handleArithmeticAction('/'));
        buttonEquality.setOnAction(event -> handleArithmeticAction('='));

        buttonClear.setOnAction(event -> clearLabelResult());

        btn0.setOnAction(event -> handleButtonPressing('0'));
        btn1.setOnAction(event -> handleButtonPressing('1'));
        btn2.setOnAction(event -> handleButtonPressing('2'));
        btn3.setOnAction(event -> handleButtonPressing('3'));
        btn4.setOnAction(event -> handleButtonPressing('4'));
        btn5.setOnAction(event -> handleButtonPressing('5'));
        btn6.setOnAction(event -> handleButtonPressing('6'));
        btn7.setOnAction(event -> handleButtonPressing('7'));
        btn8.setOnAction(event -> handleButtonPressing('8'));
        btn9.setOnAction(event -> handleButtonPressing('9'));
        buttonDot.setOnAction(event -> handleButtonPressing('.'));

    }

    private void handleButtonPressing(char number) {
        try {
            if (labelResult.getText().equals("0") && number != '.') {
                showTextOfLabelResult(String.valueOf(number));
            } else {
                showTextOfLabelResult(labelResult.getText() + number);
            }
            if (isActorA) {
                arithmeticWorker.setFirstNumber(Double.parseDouble(labelResult.getText().trim()));
            } else {
                arithmeticWorker.setSecondNumber(Double.parseDouble(labelResult.getText().trim()));
            }
        } catch (NumberFormatException e) {
            clearLabelResult();
        }
    }

    private void handleArithmeticAction(char action) {
        setDefaultColors();
        labelResult.setText("");
        if (isActorA) {
            arithmeticWorker.setAction(action);
            isActorA = false;
        } else {
            double result = arithmeticWorker.getResult();
            showTextOfLabelResult(String.valueOf(result).equals("0.0") ? "0" : String.valueOf(result));
            arithmeticWorker.setFirstNumber(result);
            isActorA = true;
        }
        switch (action) {
            case '+' -> {
                buttonAddition.setStyle("-fx-background-color: #CC9966; -fx-background-radius: 100;");
            }
            case '-' -> {
                buttonSubtraction.setStyle("-fx-background-color: #CC9966; -fx-background-radius: 100;");
            }
            case '*' -> {
                buttonMultiplication.setStyle("-fx-background-color: #CC9966; -fx-background-radius: 100;");
            }
            case '/' -> {
                buttonDivision.setStyle("-fx-background-color: #CC9966; -fx-background-radius: 100;");
            }
        }
    }

    private void showTextOfLabelResult(String string) {
        labelResult.setText(string);
        if (string.length() > 8 && string.length() < 16) {
            labelResult.setFont(FONT_MEDIUM);
        } else if (string.length() >= 16)
            labelResult.setFont(FONT_SMALL);
        else
            labelResult.setFont(FONT_REGULAR);
    }

    private void clearLabelResult() {
        labelResult.setText("0");
        labelResult.setFont(FONT_REGULAR);
        arithmeticWorker.setFirstNumber(0);
        arithmeticWorker.setSecondNumber(0);
        isActorA = true;
    }

    private void setDefaultColors() {
        buttonAddition.setStyle("-fx-background-color: #FF9933; -fx-background-radius: 100;");
        buttonSubtraction.setStyle("-fx-background-color: #FF9933; -fx-background-radius: 100;");
        buttonMultiplication.setStyle("-fx-background-color: #FF9933; -fx-background-radius: 100;");
        buttonDivision.setStyle("-fx-background-color: #FF9933; -fx-background-radius: 100;");
    }
}
