package logicCalculator;

import io.ConsolePrinter;
import io.DataReader;

public class CalcMethods {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String EXIT = "c";

    ConsolePrinter printer = new ConsolePrinter();
    DataReader dataReader = new DataReader(printer);

    public double math(String operator) {
        double result = 0;
        do {
                switch (operator) {
                    case PLUS:
                        printer.printLine("Napisz równanie:");
                        double a = dataReader.getDouble();
                        printer.printLine(" + ");
                        double b = dataReader.getDouble();
                        result = a + b;
                        printer.printLine(a + " + " + b + " = " + result);
                        operator = "c";
                        break;
                    case MINUS:
                        //result = a - b;
                        break;
                    case MULTIPLY:
                        //result = a * b;
                        break;
                    case DIVIDE:
                        //result = a / b;
                        break;
                    case EXIT:
                        break;
                    default:
                        System.out.println("Nie znaleziono takiej opcji");
                }
        } while (operator != EXIT);
        return result;
    }

}
