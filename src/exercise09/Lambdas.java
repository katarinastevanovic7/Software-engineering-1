package exercise09;

import exercise08.IpvqAddress;

import java.util.function.Predicate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Lambdas {

    public static void main(String[] args) {
        // Beispiel für a und b:
        Predicate<Integer> isPositive = n -> n > 0; // a)
        System.out.println(isPositive.test(15)); // b)

        // Hier Ihr Code:
        // 1 a+b)

        System.out.println("Prädikat, was für einen String bewertet (mit true/false), ob diese mit einem A oder a anfängt:");
        Predicate<String> startsWithA = s -> s.startsWith("a") || s.startsWith("A");    // Predicate-Interface: Eingabewert Typ T, Rückgabewert boolesch
        System.out.println(startsWithA.test("anna"));
        System.out.println(startsWithA.test("Anna"));
        System.out.println(startsWithA.test("Katarina"));

        System.out.println("Fakultätsfunktion:");
        Function<Integer, Integer> factorial = n -> {   // Function-Interface: Eingabewert Typ T, Rückgabewert Typ R
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println(factorial.apply(5));

        System.out.println("Funktion zur Subtraktion zweier Double-Werte:");
        DoubleBinaryOperator subtract = (a, b) -> a - b;    //BinaryOperator-Interface: zwei Eingabewerte Typ T, denselben Rückgabewert Typ T
        System.out.println(subtract.applyAsDouble(2, 1));

        System.out.println("Funktion, die eine zufällige Integer-Zahl zwischen 0 und 9 erzeugt:");
        IntSupplier randomInt = () -> {     // Supplier-Interface: keinen Eingabewert, Rückgabewert Typ T
            Random random = new Random();
            return random.nextInt(10);
        };
        System.out.println(randomInt.getAsInt());

        System.out.println("Funktion, die eine Zeichenkette in Großbuchstaben umwandelt und auf der Konsole ausgibt (keine Rückgabe, nur Ausgabe!):");
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());     // Consumer-Interface: Eingabewert Typ T, kein Rückgabewert
        printUpperCase.accept("klappts ?");

        // 1 c)

        /*
        Comparator<Person> c = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
     }

         */
        Comparator<Person> c = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        // zwei Objekte vom Typ Person werden übergeben und mit .compareTo verglichen



        // 1 d)

        List<IpvqAddress> addresses = new ArrayList<>();
        addresses.add(new IpvqAddress("100;100;100;11;1"));
        addresses.add(new IpvqAddress("100;100;100;2;1"));
        addresses.add(new IpvqAddress("100;100;100;2;2"));
        addresses.add(new IpvqAddress("100;100;100;2;10"));
        addresses.add(new IpvqAddress("100;100;100;2;11"));
        addresses.add(new IpvqAddress("254;100;100;2;200"));
        addresses.add(new IpvqAddress("100;254;111;11;1"));
        addresses.add(new IpvqAddress("100;100;254;2;1"));
        addresses.add(new IpvqAddress("55;123;100;4;2"));
        addresses.add(new IpvqAddress("100;241;100;2;23"));
        addresses.add(new IpvqAddress("100;2;231;2;123"));
        addresses.add(new IpvqAddress("241;100;100;2;22"));

        Comparator<IpvqAddress> comparator = (a1, a2) -> {
            int components1 = a1.getComponent5();
            int components2 = a2.getComponent5();

            return Integer.compare(components1, components2);
        };

        Collections.sort(addresses, comparator.reversed());
        //Collections.reverse(addresses);

        for (IpvqAddress address : addresses) {
            System.out.println(address);
        }
    }
}
