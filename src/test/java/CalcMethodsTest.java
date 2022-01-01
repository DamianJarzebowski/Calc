import io.ConsolePrinter;
import io.DataReader;
import logicCalculator.CalcMethods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class CalcMethodsTest {


    @Test
    public void shouldAddValues() {
        var input = new MyInput();
        var printer = new MyPrinter();
        var sut = new CalcMethods(printer, input);
        sut.equation("+");
        Assertions.assertThat(printer.lastText).isEqualTo("0.0 + 5.0 = 5.0");
    }
}

class MyPrinter implements ConsolePrinter {
    String lastText;

    @Override
    public void printLine(String text) {
        this.lastText = text;
    }
}

class MyInput implements DataReader {

    private LinkedList<Double> entrys = new LinkedList<>();

    public MyInput() {
        this.entrys.add(0.0);
        this.entrys.add(5.0);
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public double getDouble() {
        return entrys.poll();
    }

    @Override
    public String getString() {
        return null;
    }
}