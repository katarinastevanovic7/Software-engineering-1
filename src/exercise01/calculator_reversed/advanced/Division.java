package exercise01.calculator_reversed.advanced;

public class Division implements IBinaryOperation {

    @Override
    public double calculate(double first, double second) {
        return first / second;
    }

    @Override
    public String getName() {
        return "Division";
    }
}

