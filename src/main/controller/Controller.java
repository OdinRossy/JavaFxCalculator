package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import main.ArithmeticWorker;

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
    private ArithmeticWorker arithmeticWorker = new ArithmeticWorker();
    private double result;

    @FXML
    protected void initialize() {

        arithmeticWorker.setFirstNumber(0);
        arithmeticWorker.setSecondNumber(0);

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
        showInLabelResult(labelResult.getText() + number);
        if (isActorA) {
            arithmeticWorker.setFirstNumber(Double.parseDouble(labelResult.getText().trim()));
        } else {
            arithmeticWorker.setSecondNumber(Double.parseDouble(labelResult.getText().trim()));
        }
        System.out.println("first number:" + arithmeticWorker.getFirstNumber());
        System.out.println("second number:" + arithmeticWorker.getSecondNumber());
    }

    private void handleArithmeticAction(char action) {
        labelResult.setText("");
        if (isActorA){
            arithmeticWorker.setAction(action);
            isActorA = false;
        } else {
            result = arithmeticWorker.getResult();
            showInLabelResult(String.valueOf(result));
            arithmeticWorker.setFirstNumber(result);
            isActorA = true;
        }
    }

    private void showInLabelResult(String string) {
        labelResult.setText(string);
        if (string.length() > 8){
            labelResult.setFont(new Font(40));
        } else
            labelResult.setFont(new Font(60));
    }

    private void clearLabelResult() {
        labelResult.setText("");
        arithmeticWorker.setFirstNumber(0);
        arithmeticWorker.setSecondNumber(0);
        isActorA = true;
    }
}
