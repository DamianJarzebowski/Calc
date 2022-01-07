package calc.logic;

public class CalcMethods {

    public double memory;

    /**
     * It calculate result of operation base of memory, operator and value.
     *
     * @param operator: +, -, *, /.
     * @param value     the value.
     * @return result of the operation.
     * @throws ArithmeticException when value is 0
     */
    public double equation(String operator, double value) {
        return memory = chooseMathematicalOperation(operator, value);
    }

    private double chooseMathematicalOperation(String operator, double value) {
        double result = 0;
        if ("+".equals(operator)) {
            result = addition(value);
        } else if ("-".equals(operator)) {
            result = subtraction(value);
        } else if ("*".equals(operator)) {
            result = multiplication(value);
        } else if ("/".equals(operator)) {
            result = division(value);
        }
        return result;
    }

    private double addition(double value) {
        return value + memory;
    }

    private double subtraction(double value) {
        return memory - value;
    }

    private double multiplication(double value) {
        return memory * value;
    }

    private double division(double value) {
        if (value == 0)
            throw new ArithmeticException("Nie wolno dzielić przez 0");
        else
            return memory / value;
    }

    public void clear() {
        memory = 0;
    }

}
