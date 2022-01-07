import calc.logic.CalcMethods;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class CalcMethodsTest {

    @Test
    public void shouldAdditionValues() {
        var sut = new CalcMethods();
        sut.memory = 0;
        var actual = sut.equation("+", 5);
        assertThat(actual).isEqualTo(5.0);
    }

    @Test
    public void shouldSubtractionValues() {
        var sut = new CalcMethods();
        sut.memory = 0;
        var actual = sut.equation("-", 5);

        assertThat(actual).isEqualTo(-5.0);
    }

    @Test
    public void shouldMultiplicationValues() {
        var sut = new CalcMethods();
        sut.memory = 2;
        var actual = sut.equation("*", 5);
        assertThat(actual).isEqualTo(10.0);
    }

    @Test
    public void shouldDivisionValues() {
        var sut = new CalcMethods();
        sut.memory = 5;
        final var actual = sut.equation("/", 5);
        assertThat(actual).isEqualTo(1.0);
    }

    @Test
    public void shouldThrownArithmeticException() {
        try {
            var sut = new CalcMethods();
            sut.equation("/", 0);
            fail("Wyjątek nie rzucony");
        } catch (ArithmeticException e) {
            var expected = "Nie wolno dzielić przez 0";
            assertThat(e.getMessage()).isEqualTo(expected);
        }
    }

    @Test
    public void shouldClearMemory() {
        var sut = new CalcMethods();
        sut.memory = 5;
        sut.clear();
        assertThat(sut.memory).isEqualTo(0.0);
    }

    @Test
    public void shouldSeparateObject() {
        var c1 = new CalcMethods();
        var c2 = new CalcMethods();
        c1.equation("+", 1);
        assertThat(c2.equation("+", 1)).isEqualTo(1);
    }

}
