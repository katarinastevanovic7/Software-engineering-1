package exercise01.calculator_reversed.advanced;

public class Power implements IBinaryOperation {

    @Override
    public double calculate(double first, double second) {
        return Math.pow(first, second);
    }

    @Override
    public String getName() {
        return "Power";
    }
}

