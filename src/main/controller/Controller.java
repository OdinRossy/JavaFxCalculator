package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public Button btn0;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;

    public Button buttonDot;

    public Button buttonAddition;
    public Button buttonSubtraction;

    public Button buttonMultiplication;
    public Button buttonDivision;

    public Button buttonEquality;

    public Button buttonClear;

    public Label labelResult;

    private double a;
    private double b;
    private double result;
    private ArithmeticOperator arithmeticOperator = new ArithmeticOperator();

    private boolean isActorA = true;

    private char action;

    @FXML
    protected void initialize() {

        labelResult.setText("");
        a = 0;
        b = 0;

        buttonAddition.setOnAction(event -> onArithmeticAction('+'));
        buttonSubtraction.setOnAction(event -> onArithmeticAction('-'));
        buttonMultiplication.setOnAction(event -> onArithmeticAction('*'));
        buttonDivision.setOnAction(event -> onArithmeticAction('/'));
        buttonEquality.setOnAction(event -> onArithmeticAction('='));

        buttonClear.setOnAction(event -> clearLabelResult());

        btn0.setOnAction(event -> showInLabelResult("0"));
        btn1.setOnAction(event -> showInLabelResult("1"));
        btn2.setOnAction(event -> showInLabelResult("2"));
        btn3.setOnAction(event -> showInLabelResult("3"));
        btn4.setOnAction(event -> showInLabelResult("4"));
        btn5.setOnAction(event -> showInLabelResult("5"));
        btn6.setOnAction(event -> showInLabelResult("6"));
        btn7.setOnAction(event -> showInLabelResult("7"));
        btn8.setOnAction(event -> showInLabelResult("8"));
        btn9.setOnAction(event -> showInLabelResult("9"));
        buttonDot.setOnAction(event -> showInLabelResult("."));

    }

    private void onArithmeticAction(char ch) {

        if (isActorA) {
            arithmeticOperator.setFirstNumber(Double.parseDouble(labelResult.getText()));
            labelResult.setText("");
            isActorA = false;
            action = ch;
        } else {
            arithmeticOperator.setSecondNumber(Double.parseDouble(labelResult.getText()));

        }
    }

    private void showInLabelResult(String string) {
        labelResult.setText(labelResult.getText() + string);
    }

    private void clearLabelResult() {
        isActorA = true;
        a = 0;
        b = 0;
        labelResult.setText("");
    }

}
