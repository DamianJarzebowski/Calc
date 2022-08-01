package calc;

import calc.io.ConsolePrinter;
import calc.io.ConsolePrinterImpl;
import calc.io.DataReader;
import calc.io.DataReaderImpl;
import calc.logic.CalcMethods;

import java.util.InputMismatchException;

public class ControlCalc {

    ConsolePrinter printer;
    DataReader dataReader;
    CalcMethods calcMethods = new CalcMethods();

    public ControlCalc(ConsolePrinter printer, DataReader dataReader) {
        this.printer = printer;
        this.dataReader = dataReader;
    }

    public ControlCalc() {
        this(new ConsolePrinterImpl(), new DataReaderImpl());
    }

    void calcController() {

        Option option = null;

        do {
            printOptions();
            try {
                option = getOption();
                switch (option) {
                    case EXIT -> printer.printLine("Zamykam program!");
                    case CLEAR -> calcMethods.clear();
                    case PLUS, MINUS, MULTIPLIER, DIVIDER -> count(option.toString());
                }
            } catch (NullPointerException e) {
                System.err.println("Nie ma takiej opcji.");
            } catch (InputMismatchException e) {
                System.err.println("Podaj liczbę.");
            }
        } while (option != Option.EXIT);
    }

    private void count(String operator) {
        try {
            double number = dataReader.getDouble();
            var actual = calcMethods.apply(operator, number);
            printer.printLine(actual + "");
        } catch (ArithmeticException e) {
            e.getMessage();
        }
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