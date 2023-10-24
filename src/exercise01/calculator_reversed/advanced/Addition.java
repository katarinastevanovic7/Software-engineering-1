package exercise01.calculator_reversed.advanced;

public class Addition implements IBinaryOperation {

    @Override
    public double calculate(double first, double second) {
        return first + second;
    }

    @Override
    public String getName() {
        return "Addition";
    }
}
