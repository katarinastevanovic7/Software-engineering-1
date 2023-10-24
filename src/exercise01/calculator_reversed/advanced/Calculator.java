package exercise01.calculator_reversed.advanced;


public class Calculator {

    private IBinaryOperation[] operations =
            new IBinaryOperation[]{new Power(), new Division(), new Multiplication(), new Subtraction(), new Addition()};

    //new Addition(), new Subtraction(), new Multiplication(), new Division(), new Power()
    public String[] listOperations() {
        String[] list = new String[operations.length];

        for (int i = 0; i < operations.length; i++) {
            list[i] = String.format("(%d) %s", i, operations[i].getName());
        }

        return list;
    }

    public IBinaryOperation getOperation(int nr) {
        return operations[nr];
    }
}
