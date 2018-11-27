package main;

public class ArithmeticWorker {

    private double firstNumber;
    private double secondNumber;
    private char action;

    public double getResult() {
        switch (action) {
            case '+' : return this.firstNumber + this.secondNumber;
            case '-' : return this.firstNumber - this.secondNumber;
            case '*' : return this.firstNumber * this.secondNumber;
            case '/' : return this.firstNumber / this.secondNumber;
            default: return 0;
        }
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
