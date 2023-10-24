package exercise01.calculator_reversed.advanced;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Willkommen!");

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double first;
        double second;
        double result = 0;
        int selectedOperation;

        while (true) {
            System.out.println("Welche Operation?");
            for (String menuEntry : calculator.listOperations()) {
                System.out.println(menuEntry);
            }
            System.out.println("(99) Beenden");
            selectedOperation = scanner.nextInt();

            if (selectedOperation == 99) {
                break;
            }

            System.out.print("Bitte erste Zahl eingeben: ");
            first = scanner.nextDouble();
            System.out.print("Bitte zweite Zahl eingeben: ");
            second = scanner.nextDouble();
            IBinaryOperation operation = calculator.getOperation(selectedOperation);
            result = operation.calculate(first, second);
            System.out.printf("Ergebnis: %f%n%n", result);
        }
    }
}
