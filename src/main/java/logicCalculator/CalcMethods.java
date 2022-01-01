package logicCalculator;

import io.ConsolePrinter;
import io.DataReader;

public class CalcMethods {

    ConsolePrinter printer = new ConsolePrinter();
    DataReader dataReader = new DataReader(printer);

    public double math(String operator, double memory) {
        return equation(operator, memory);
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
        var b = dataReader.getDouble();
        var result = calculateTheAction(operator, a, b);
        printer.printLine(a + " " + operator + " " + b + " = " + result);
        return result;
    }

    double calculateTheAction(String operator, double a, double b) {
        double result = 0;
        if ("+".equals(operator)) {
            result = addition(a, b);
        }
        else if ("-".equals(operator)) {
            result = subtraction(a, b);
        }
        else if ("*".equals(operator)) {
            result = multiplication(a, b);
        }
        else if ("/".equals(operator)) {
            try {
            result = division(a, b);
            } catch (ArithmeticException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    double addition(double a, double b) {
        return a + b;
    }
    double subtraction(double a, double b) {
        return a - b;
    }
    double multiplication(double a, double b) {
        return a * b;
    }
    double division(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Nie wolno dzielić przez 0");
            else
                return a / b;
    }

}
