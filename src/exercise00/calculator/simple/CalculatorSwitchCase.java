package exercise00.calculator.simple;

import java.util.Scanner;

public class CalculatorSwitchCase {


    public static void main(String[] args) {
        System.out.println("Willkommen!");

        Scanner scanner = new Scanner(System.in);
        double first;
        double second;
        double result = 0;
        int operation;

        while (true) {
            System.out.println("Welche Operation?");
            System.out.println("(0) Addieren");
            System.out.println("(1) Subtrahieren");
            System.out.println("(2) Multiplication");
            System.out.println("(3) Division");
            System.out.println("(4) Power");
            System.out.println("(99) Beenden");
            operation = scanner.nextInt();
            if (operation == 99) {
                break;
            }

            System.out.print("Bitte erste Zahl eingeben: ");
            first = scanner.nextDouble();
            System.out.print("Bitte zweite Zahl eingeben: ");
            second = scanner.nextDouble();

          /*  if (operation == 0) {
                result = first + second;
            } else if (operation == 1) {
                result = first - second;
            }*/

            switch (operation) {
                case 0:
                    result = first + second;
                    break;
                case 1:
                    result = first - second;
                    break;
                case 2:
                    result = first * second;
                    break;
                case 3:
                    result = first / second;
                    break;
                case 4:
                    result = Math.pow(first, second);
                    break;
                default:

            }

            System.out.printf("Ergebnis: %f%n%n", result);
        }

        System.out.println("Bye bye!");
        scanner.close();
    }
}


