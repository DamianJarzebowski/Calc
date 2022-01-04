package app;

import io.ConsolePrinter;
import io.ConsolePrinterImpl;
import io.DataReader;
import io.DataReaderImpl;
import logicCalculator.CalcMethods;

import java.util.InputMismatchException;

public class ControlCalc {

    ConsolePrinter printer = new ConsolePrinterImpl();
    DataReader dataReader = new DataReaderImpl();
    CalcMethods calcMethods = new CalcMethods();

    void calcController() {

        Option option = null;

        do {
            printOptions();
            try {
                double number = dataReader.getDouble();
                option = getOption();
                switch (option) {
                    case EXIT -> printer.printLine("Zamykam program!");
                    case CLEAR -> calcMethods.clear();
                    case PLUS, MINUS, MULTIPLIER, DIVIDER -> count(number, option.toString());
                }
            } catch (NullPointerException e) {
                System.err.println("Nie ma takiej opcji.");
            } catch (InputMismatchException e) {
                System.err.println("Podaj liczbę.");
            }
        } while (option != Option.EXIT);
    }

    private void count(double number, String operator) {
        var actual = calcMethods.equation(operator, number);
            printer.printLine(actual + "");
    }

    private void printOptions() {
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            option = Option.createOptionFromDescription(dataReader.getString());
            optionOk = true;
        }
        return option;
    }

    private enum Option {
        EXIT("OFF"),
        CLEAR("C"),
        PLUS("+"),
        MINUS("-"),
        MULTIPLIER("*"),
        DIVIDER("/");

        private final String description;

        Option(String desc) {
            this.description = desc;
        }

        @Override
        public String toString() {
            return description;
        }

        static Option createOptionFromDescription(String options) {
            Option option = null;
            for (int i = 0; i < Option.values().length; i++) {
                if (Option.values()[i].description.equals(options))
                    option = Option.values()[i];
            }
            return option;
        }
    }
}