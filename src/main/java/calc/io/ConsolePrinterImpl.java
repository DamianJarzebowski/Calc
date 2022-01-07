package calc.io;

public class ConsolePrinterImpl implements ConsolePrinter {

    @Override
    public void printLine(String text) {
        System.out.println(text);
    }
}
