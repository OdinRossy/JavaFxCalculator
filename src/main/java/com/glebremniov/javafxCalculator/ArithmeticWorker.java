package com.glebremniov.javafxCalculator;

public class ArithmeticWorker {

    private double firstNumber;
    private double secondNumber;
    private char action;

    public double getResult() {
        return switch (action) {
            case '+' -> this.firstNumber + this.secondNumber;
            case '-' -> this.firstNumber - this.secondNumber;
            case '*' -> this.firstNumber * this.secondNumber;
            case '/' -> this.firstNumber / this.secondNumber;
            case '=' -> firstNumber;
            default -> 0;
        };
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setAction(char action) {
        this.action = action;
    }
}
