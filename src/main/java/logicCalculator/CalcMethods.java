package logicCalculator;

public class CalcMethods {

    public double memory;

    public double equation(String operator, double a) {
        return memory = chooseMathematicalOperation(operator, a);
    }

    public double chooseMathematicalOperation(String operator, double a) {
        double result = 0;
        if ("+".equals(operator)) {
            result = addition(a);
        }
        else if ("-".equals(operator)) {
            result = subtraction(a);
        }
        else if ("*".equals(operator)) {
            result = multiplication(a);
        }
        else if ("/".equals(operator)) {
            try {
            result = division(a);
            } catch (ArithmeticException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    double addition(double a) {
        return a + memory;
    }
    double subtraction(double a) {
        return memory - a;
    }
    double multiplication(double a) {
        return memory * a;
    }
    public double division(double a) {
        if (a == 0 || memory == 0)
            throw new ArithmeticException("Nie wolno dzielić przez 0");
            else
                return memory / a;
    }

    public void clear() {
        memory = 0;
    }

}
