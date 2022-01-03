package app;

import io.ConsolePrinter;
import io.ConsolePrinterImpl;
import io.DataReader;
import io.DataReaderImpl;
import logicCalculator.CalcMethods;

public class ControlCalc {

    ConsolePrinter printer = new ConsolePrinterImpl();
    DataReader dataReader = new DataReaderImpl();
    CalcMethods calcMethods = new CalcMethods();

    boolean error = true;

    void calcController() {

        Option option;

        do {
            printOptions();
            option = getOption();
            try {
            switch (option) {
                case EXIT:
                    printer.printLine("Zamykam program!");
                    break;
                case CLEAR:
                    calcMethods.clear();
                    break;
                case PLUS:
                    printer.printLine("Zamykam +!");
                    break;
                case MINUS:
                    printer.printLine("Zamykam -!");
                    break;
                case MULTIPLIER:
                    printer.printLine("Zamykam *!");
                    break;
                case DIVIDER:
                    printer.printLine("Zamykam /!");
                    break;
                case ACTION:
                    printer.printLine("(+, -, *, /)");
                    do {
                        String operator = dataReader.getString();
                        double a = dataReader.getDouble();
                        if (calcMethods.isSuporttedOperator(operator)) {
                            printer.printLine("Napisz równanie:");
                            var actual = calcMethods.equation(operator, a);
                            printer.printLine(actual + "");
                            error = false;
                        } else {
                            System.err.println("Wybierz + lub - lub * lub /");
                        }
                    } while (error);
            } } catch (NullPointerException e) {
                System.err.println("Nie ma takiej opcji.");
            }
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
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
        DIVIDER("/"),
        ACTION("ACTION");

        private final String description;

        Option(String desc) {
            this.description = desc;
        }

        @Override
        public String toString() {
            return description;
        }

        static Option createOptionFromDescription(String options){
                Option option = null;
                for (int i = 0; i < Option.values().length; i++) {
                    if (Option.values()[i].description.equals(options))
                        option = Option.values()[i];
                }
                return option;
        }
    }
}