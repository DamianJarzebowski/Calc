package calc;

import calc.io.ConsolePrinter;
import calc.io.DataReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ControlCalcTest {

    @Test
    public void shouldExit() {
        var printer = new MyPrinter();
        var input = new MyInput();
        var sut = new ControlCalc(printer, input);
        sut.calcController();
    }

    @Test
    public void shouldAdd() {
        var printer = new MyPrinter2();
        var input = new MyInput2();
        var sut = new ControlCalc(printer, input);
        sut.calcController();
        Assertions.assertThat(printer.lines).contains("3.0");
    }

}

class MyPrinter implements ConsolePrinter {

    @Override
    public void printLine(String text) {

    }
}

class MyInput implements DataReader {

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public double getDouble() {
        return 0;
    }

    @Override
    public String getString() {
        return "OFF";
    }
}

class MyInput2 implements DataReader {

    LinkedList<Double> doubles = new LinkedList<>();
    LinkedList<String> strings = new LinkedList<>();

    public MyInput2() {
        doubles.add(1.0);
        doubles.add(2.0);
        strings.add("+");
        strings.add("+");
        strings.add("OFF");
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public double getDouble() {
        return doubles.poll();
    }

    @Override
    public String getString() {
        return strings.poll();
    }
}

class MyPrinter2 implements ConsolePrinter {

    List<String> lines = new ArrayList<>();

    @Override
    public void printLine(String text) {
        lines.add(text);
    }
}