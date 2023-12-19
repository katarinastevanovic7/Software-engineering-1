package exercise09;

import java.util.*;
import java.util.stream.Collectors;

public class PersonMain {

    public static Person ANNA = new Person("Anna", "Schmitt", 10000001, 21);
    public static Person BEN = new Person("Ben", "Schmitt", 10000002, 21);
    public static Person CEM = new Person("Cem", "Demir", 10000993, 25);
    public static Person DALIA = new Person("Dalia", "Davon", 10000784, 13);
    public static Person EVELINE = new Person("Eveline", "Boiselle", 10000005, 31);
    public static Person FRANK = new Person("Frank", "Fiedel", 10000116, 29);
    public static Person GEORGE = new Person("George", "Turner", 10000127, 29);
    public static Person HANNA = new Person("Hanna", "Härder", 10000988, 29);

    public static List<Person> ALL_PERSONS = Arrays.asList(new Person[]{ANNA, BEN, CEM, DALIA, EVELINE, FRANK, GEORGE, HANNA});

    public static void main(String[] args) {
        System.out.println(ALL_PERSONS);

        Optional<Person> anna = ALL_PERSONS.stream()
                .filter(person -> person.getFirstName().equals("Anna"))
                .findFirst();
        System.out.println(anna.get());

        // a)  sortierte Liste aller Personen, die volljährig sind
        System.out.println("==== a)");
        List<Person> sortedAdults = ALL_PERSONS
                .stream()                                     // open stream pipeline
                .filter(person -> person.getAge() >= 18)      // intermediate operation
                .sorted()                                     // terminal operation
                .collect(Collectors.toList());                // terminal operation
        sortedAdults.forEach(System.out::println);
        //  System.out.println(sortedAdults);

        // b) die Nachnamen als Datentyp "Menge"
        System.out.println("==== b)");
        Set<String> lastNamesSet = ALL_PERSONS
                .stream()
                .map(person -> person.getLastName())
                .collect(Collectors.toSet());
        System.out.println(lastNamesSet);

        // c)  Liste aller Personen, deren ID durch 3 teilbar ist
        System.out.println("==== c)");
        List<Person> idDivisibleBy3 = ALL_PERSONS.stream()
                .filter(person -> person.getIdentityNumber() % 3 == 0)
                .collect(Collectors.toList());
        idDivisibleBy3.forEach(x -> System.out.println(x));
        // System.out.println(idDivisibleBy3);

        // d)  Gibt es eine Person, die mindestens 40 Jahre alt ist?
        System.out.println("==== d)");
        boolean isOver40 = ALL_PERSONS.stream()
                .anyMatch(person -> person.getAge() >= 40);
        System.out.println("Existiert eine Person über 40 Jahre alt? " + isOver40);

        // e) Anzahl der Personen, deren Nachname mit S beginnt.
        System.out.println("==== e)");
        long startsWithSCount = ALL_PERSONS.stream()
                .filter(person -> person.getLastName().startsWith("S"))
                .count();
        System.out.println("Anzahl der Personen mit Nachnamen, die mit 'S' beginnen: " + startsWithSCount);


        // f) Summe aller Alter
        System.out.println("==== f)");
        int totalAge = ALL_PERSONS.stream()
                .mapToInt(person -> person.getAge())       //mapToInt um numerische Werte aus Objekten (hier Person) zu extrahieren
                .sum();
        System.out.println("Summe aller Alter: " + totalAge);


        // g)  Map, die Nachnamen auf Person abbildet.
        System.out.println("==== g)");
        Map<String, List<Person>> lastNameToPersonMap = ALL_PERSONS.stream()
                .collect(Collectors.groupingBy(
                        person -> person.getLastName(),
                        Collectors.toList()));
        System.out.println(lastNameToPersonMap);
        lastNameToPersonMap.forEach((lastName, persons) -> {
            System.out.println(lastName + ":");
            persons.forEach(x -> System.out.println(x));
            System.out.println();
        });

        // h)  Ausgabe aller Nachnamen ohne Duplikate (Verwenden Sie distinct() und forEach())
        System.out.println("==== h)");
        ALL_PERSONS.stream()
                .map(person -> person.getLastName())
                .distinct()                             // remove duplicates
                .forEach(x -> System.out.println(x));

        // i)
        //System.out.println("==== i)");
        // TODO
    }
}
