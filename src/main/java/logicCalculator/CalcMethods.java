package logicCalculator;

public class CalcMethods {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String EXIT = "c";


    public double math(double a, double b, String operator) {
        double result = 0;
        do {
                switch (operator) {
                    case PLUS:
                        //add();
                        break;
                    case MINUS:
                        //subtraction();
                        break;
                    case MULTIPLY:
                        //multiplication();
                        break;
                    case DIVIDE:
                        //division();
                        break;
                    case EXIT:
                        break;
                    default:
                        System.out.println("Nie znaleziono takiej opcji");
                }
        } while (operator != EXIT) ;
        return result;
    }

}
