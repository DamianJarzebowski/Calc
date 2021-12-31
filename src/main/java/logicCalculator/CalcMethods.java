package logicCalculator;

import io.ConsolePrinter;
import io.DataReader;

public class CalcMethods {

    ConsolePrinter printer = new ConsolePrinter();
    DataReader dataReader = new DataReader(printer);
    private double result;

    public double math(String operator, double memory) {
        return result = equation(operator, memory);
    }

    double equation(String operator, double memory) {
        printer.printLine("Napisz równanie:");
        double a;
        if (memory == 0) {
            a = dataReader.getDouble();
        }
        else {
            a = memory;
            printer.printLine(a + "");
        }
        printer.printLine(operator);
        double b = dataReader.getDouble();
        double result = calculateTheAction(operator, a, b);
        printer.printLine(a + " " + operator + " " + b + " = " + result);
        return result;
    }

    double calculateTheAction(String operator, double a, double b) {
        double result = 0;
        if ("+".equals(operator)) {
            result = a + b;
        }
        else if ("-".equals(operator)) {
            result = a - b;
        }
        else if ("*".equals(operator)) {
            result = a * b;
        }
        else if ("/".equals(operator)) {
            result = a / b;
        }
        return result;
    }

}
