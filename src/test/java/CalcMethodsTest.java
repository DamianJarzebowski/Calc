import calc.logic.CalcMethods;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

public class CalcMethodsTest {

    @Test
    public void shouldAdditionValues() {
        var sut = new CalcMethods();
        var actual = sut.apply("+", 5);
        assertThat(actual).isEqualTo(5.0);
    }

    @Test
    public void shouldSubtractionValues() {
        var sut = new CalcMethods();
        var actual = sut.apply("-", 5);

        assertThat(actual).isEqualTo(-5.0);
    }

    @Test
    public void shouldMultiplicationValues() {
        var sut = new CalcMethods();
        sut.apply("+", 2);
        var actual = sut.apply("*", 5);
        assertThat(actual).isEqualTo(10.0);
    }

    @Test
    public void shouldDivisionValues() {
        var sut = new CalcMethods();
        sut.apply("+", 5);
        final var actual = sut.apply("/", 5);
        assertThat(actual).isEqualTo(1.0);
    }

    @Test
    public void shouldThrownArithmeticException() {
        try {
            var sut = new CalcMethods();
            sut.apply("/", 0);
            fail("Wyjątek nie rzucony");
        } catch (ArithmeticException e) {
            var expected = "Nie wolno dzielić przez 0";
            assertThat(e.getMessage()).isEqualTo(expected);
        }
    }

    @Test
    public void shouldClearMemory() {
        var sut = new CalcMethods();
        sut.apply("+", 1);
        sut.clear();
        var actual = sut.apply("+", 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void shouldSeparateObject() {
        var c1 = new CalcMethods();
        var c2 = new CalcMethods();
        c1.apply("+", 1);
        assertThat(c2.apply("+", 1)).isEqualTo(1);
    }

    @Test
    public void shouldRejectIllegalOperator() {
        assertThatThrownBy(() -> {
            var sut = new CalcMethods();
            sut.apply("Illegal", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
