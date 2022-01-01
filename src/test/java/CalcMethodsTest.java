import logicCalculator.CalcMethods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcMethodsTest {

    @Test
    public void shouldAddValues() {
        var sut = new CalcMethods();
        var actual = sut.equation("+", 5);
        Assertions.assertThat(actual).isEqualTo(5.0);
    }

    @Test
    public void shouldValidateAddOperator() {
        var sut = new CalcMethods();

        Assertions.assertThat(sut.isSuporttedOperator("+")).isTrue();
    }

}
