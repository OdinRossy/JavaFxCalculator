package main.controller;

public class ArithmeticOperator {

    private double firstNumber;

    private double secondNumber;

    public ArithmeticOperator() {
    }

    public ArithmeticOperator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getSum() {
        return firstNumber + secondNumber;
    }

    public double getSubstraction() {
        return firstNumber - secondNumber;
    }

    public double getMultiplication() {
        return firstNumber * secondNumber;
    }

    public double getDivision() {
        return firstNumber / secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
}
