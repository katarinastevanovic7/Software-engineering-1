package exercise01.calculator_reversed.advanced;

public class Multiplication implements IBinaryOperation {

    @Override
    public double calculate(double first, double second) {
        return first * second;
    }

    @Override
    public String getName() {
        return "Multiplikation";
    }
}
