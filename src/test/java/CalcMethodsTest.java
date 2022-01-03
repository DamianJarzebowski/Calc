import logicCalculator.CalcMethods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;

public class CalcMethodsTest {

    @Test
    public void shouldAdditionValues() {
        var sut = new CalcMethods();
        var actual = sut.equation("+", 5);
        Assertions.assertThat(actual).isEqualTo(5.0);
    }

    @Test
    public void shouldSubtractionValues() {
        var sut = new CalcMethods();
        var actual = sut.equation("-", 5);

        Assertions.assertThat(actual).isEqualTo(-5.0);
    }

    @Test
    public void shouldMultiplicationValues() {
        var sut = new CalcMethods();
        sut.memory = 2;
        var actual = sut.equation("*", 5);
        Assertions.assertThat(actual).isEqualTo(10.0);
    }

    @Test
    public void shouldDivisionValues() {
            var sut = new CalcMethods();
            sut.memory = 5;
                final var actual = sut.equation("/", 5);
                Assertions.assertThat(actual).isEqualTo(1.0);
    }

    @Test
    public void shouldThrownArithmeticException() {
        try {
            var sut = new CalcMethods();
            sut.division(0);
            fail("Wyjątek nie rzucony");
        }catch (ArithmeticException e) {
            var actual = "Nie wolno dzielić przez 0";
            Assertions.assertThat(actual).isEqualTo(e.getMessage());
        }
    }

    @Test
    public void shouldClearMemory() {
        var sut = new CalcMethods();
        sut.memory = 5;
        sut.clear();
        Assertions.assertThat(sut.memory).isEqualTo(0.0);
    }

    @Test
    public void shouldValidateAddOperator() {
        var sut = new CalcMethods();
        Assertions.assertThat(sut.isSuporttedOperator("+")).isTrue();
        Assertions.assertThat(sut.isSuporttedOperator("-")).isTrue();
        Assertions.assertThat(sut.isSuporttedOperator("*")).isTrue();
        Assertions.assertThat(sut.isSuporttedOperator("/")).isTrue();

    }

}
