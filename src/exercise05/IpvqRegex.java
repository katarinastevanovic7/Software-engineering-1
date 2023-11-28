package exercise05;

public class IpvqRegex {

    //3b
    public static final String IPVQ_REGEX = "^((([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511);){4}([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511))$";

    //^ = repräsentiert den Anfang der Zeichenkette
    //( und ) = Diese Klammern gruppieren Teile des Ausdrucks zusammen
    //(10-911 1-91[0-91|[1-41[0-9][0-91150[0-91/510|511) = Dieser Teil des Ausdrucks definiert eine Gruppe von Zahlen, die erlaubt sind. Ins Detail:
    //[0-9] = Eine einzelne Ziffer
    // | [1-9][0-9] = Oder eine Ziffer, die nicht mit 0 beginnt, gefolgt von einer beliebigen Ziffer
    // | [1-4][0-9][0-9] = Oder eine Ziffer zwischen 100 und 499
    // | 50[0-9] = Oder die Zahl 500 gefolgt von einer beliebigen Ziffer von 0 bis 9
    // | 510 = Oder die Zahl 510.
    // | 511 = Oder die Zahl 511.
    // ; trennt die einzelnen Zahlen in der Zeichenkette
    // {4} bedeutet, dass genau vier Kopien des vorherigen Teils (Zahl gefolgt von Semikolon) erwartet werden
    // ((...) {4} ...) besagt, dass die vorherige Gruppe genau viermal wiederholt werden sollte
    // $ repräsentiert das Ende der Zeichenkette
}
