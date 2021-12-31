package app;

import logicCalculator.CalcMethods;
import io.ConsolePrinter;
import io.DataReader;
import wyjątki.NoSuchOptionException;

import java.util.InputMismatchException;

public class ControlCalc{

    ConsolePrinter printer = new ConsolePrinter();
    DataReader dataReader = new DataReader(printer);
    CalcMethods calcMethods = new CalcMethods();

    private double memory = 0;
    private double result = 0;

    void calcController() {

        Option option;

        do {
            printOptions();
            printer.printLine(memory + "");
            option = getOption();
            switch (option) {
                case EXIT:
                    printer.printLine("Zamykam program!");
                    break;
                case CLEAR:
                    memory = 0;
                    break;
                case ACTION:
                    printer.printLine("Jakie działanie chesz wykonać? (+, -, *, /)");
                    String operator = dataReader.getString();
                    result = calcMethods.math(operator, memory);
                    memory = result;
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
