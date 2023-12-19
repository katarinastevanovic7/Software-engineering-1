package exercise08;

import java.util.*;

public class StringCollections {

    public static void main(String[] args) {
        // TODO a)
        List<String> list = new ArrayList<>();
        System.out.println("=== a) " + list);


        // TODO b)
        list.add("EPR");
        list.add("AlDa");
        list.add("AlDa");
        list.add("SWEN1");
        list.add("EPR");
        System.out.println("=== b) " + list);


        // TODO c)
        System.out.println("=== c) " + list.size());


        // TODO d)
        // jeden  Wert in eigenen Zeile ausgeben
        System.out.println("=== d) ");
        for (String entry : list) {
            System.out.println(entry);
        }


        // TODO e)
        System.out.println("=== e) " + list.get(0) + " " + list.get(list.size() - 1));


        // TODO f)
        Collections.sort(list);
        System.out.println("=== f) " + list);


        // TODO g)
        //Collections.reverse(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("=== g) " + list);


        // TODO h)
        System.out.println("=== h)");
        Set<String> listHashSet = new HashSet<>();
        listHashSet.add("EPR");
        listHashSet.add("AlDa");
        listHashSet.add("AlDa");
        listHashSet.add("SWEN1");
        listHashSet.add("EPR");

        System.out.println(listHashSet.size());

        for (String entry : listHashSet) {
            System.out.println(entry);
        }
        // Unterschiede List (mit Reihenfolge, doppelte Elemente) versus Set (keine doppelten Elemente)

    }
}

