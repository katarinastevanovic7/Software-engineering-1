package exercise11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                .limit(100)
                .collect(Collectors.toList());
        System.out.println(numbers);

    }
}
/* Das iterate erzeugt einen unendlichen Stream von Integer-Zahlen.
   Dabei ist 1 das erste Element des Streams und die Funktion n -> n + 1 gibt an, wie man aus einer Zahl n die nächste Zahl berechnen soll.
   In diesem Fall ist die nächste Zahl also einfach die nächsthöhere Ganzzahl.
   Es wird also der Stream 1, 2, 3, 4, ... erzeugt.

 */
