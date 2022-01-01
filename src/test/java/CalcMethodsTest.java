import logicCalculator.CalcMethods;
import org.junit.jupiter.api.Test;

public class CalcMethodsTest {


    @Test
    public void shouldKeepState() {
        var sut = new CalcMethods();
        sut.addition(1.1, 2);
        

        var actual = sut.add;
        assertThat(actual).isEqualTo(6);
    }


}
