package app;

import io.ConsolePrinterImpl;
import io.DataReaderImpl;
import logicCalculator.CalcMethods;
import io.ConsolePrinter;
import io.DataReader;
import wyjątki.NoSuchOptionException;
import wyjątki.UnknownOperatorException;

import java.util.InputMismatchException;

public class ControlCalc{

    ConsolePrinter printer = new ConsolePrinterImpl();
    DataReader dataReader = new DataReaderImpl(printer);
    CalcMethods calcMethods = new CalcMethods();


    boolean error = true;

    void calcController() {

        Option option;

        do {
            printOptions();
            printer.printLine(calcMethods.getMemory() + "");
            option = getOption();
            switch (option) {
                case EXIT:
                    printer.printLine("Zamykam program!");
                    break;
                case CLEAR:
                    calcMethods.clear();
                    break;
                case ACTION:
                    printer.printLine("Jakie działanie chesz wykonać? (+, -, *, /)");
                    do {
                        String operator = dataReader.getString();
                        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                            calcMethods.equation(operator);
                            error = false;
                        } else {
                            try {
                                throw new UnknownOperatorException("Nie ma takiej opcji, wybierz ponownie");
                            } catch (UnknownOperatorException e) {
                                e.printStackTrace();
                                System.err.println("Wybierz + lub - lub * lub /");
                            }
                        }
                    } while (error);
                    break;
                default:
                    printer.printLine("Nie znaleziono takiej opcji");
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
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", podaj ponownie:");
            } catch (InputMismatchException ignored) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private enum Option {
        EXIT(0, "Wyście z programu!"),
        CLEAR(1, "Czyszczenie pamięci."),
        ACTION(2, "Działania");

        private final String description;
        private final int value;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }
    }
}
