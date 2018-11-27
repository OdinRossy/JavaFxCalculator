package main;

public class ArithmeticWorker {

    private double firstNumber;
    private double secondNumber;
    private char action;

    public double getResult() {
        switch (action) {
            case '+' : return this.getFirstNumber() + this.getSecondNumber();
            case '-' : return this.getFirstNumber() - this.getSecondNumber();
            case '*' : return this.getFirstNumber() * this.getSecondNumber();
            case '/' : return this.getFirstNumber() / this.getSecondNumber();
            default: return 0;
        }
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

    public char getAction() {
        return action;
    }

    public void setAction(char action) {
        this.action = action;
    }
}
