package calc;


import calc.exceptions.NoSuchOptionException;

public class CalcApp {
    public static void main(String[] args) throws NoSuchOptionException {

        var appStart = new ControlCalc();

        appStart.calcController();

    }
}
