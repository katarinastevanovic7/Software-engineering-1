package exercise06;

import java.util.Locale;

public class MultiFunctionalUtility {

    private MultiFunctionalUtility() {
        // This is a class with only static utility methods.
        // A private constructor avoids that this class can be instantiated.
    }

    //TODO 1a) Implement divide and add the other methods (as static methods!)
    //         Don't forget to add JavaDoc!

    /**
     * Diese Methode nimmt zwei Double-Argumente entgegen und gibt das Ergebnis der Division zurück
     *
     * @param divident Dividend der Division
     * @param divisor  Divisor der Division
     * @return Ergebnis der Division als Double
     * @throws ArithmeticException wenn der Divisor 0 ist
     */
    public static double divide(double divident, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt!");
        }
        double result = divident / divisor;
        return result;
    }

    /**
     * Diese Methode nimmt eine Integer-Zahl als Argument und berechnet die Fakultät dieser Zahl.
     *
     * @param number Zahl, von der die Fakultät berechnet werden soll
     * @return Fakultät der Zahl als Integer
     * @throws IllegalArgumentException wenn die Zahl negativ ist
     */
        //IllegalArgumentException: Parameter ist nicht null, aber hat ungültigen Wert
    public static int faculty(int number) throws IllegalArgumentException {
        if(number < 0) {
            throw new IllegalArgumentException("Negative Zahlen haben keine Fakultät");
        }
        int result = 1;
        for (int i = 1; i <= number ; i++) {
            result = result * i;
        }
        return result;
    }


    /**
     * Diese Methode nimmt einen String und eine Integer-Zahl entgegen und gibt einen neuen String zurück,
     * der den ursprünglichen String die angegebene Anzahl von Malen multipliziert.
     *
     * @param S String, der multipliziert werden soll
     * @param n Anzahl der Male, die der String multipliziert werden soll
     * @return neuer String, der den ursprünglichen String multipliziert enthält
     * @throws IllegalArgumentException wenn n kleiner als 1 ist
     */
    //IllegalArgumentException: Parameter ist nicht null, aber hat ungültigen Wert
    public static String multiplyString(String S, int n) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("Die Anzahl der Multiplikationen muss größer als 0 sein!");
        }
        StringBuilder text  = new StringBuilder();
        //Stringbuilder erlaubt ie direkte Änderung des Inhalts, ohne ständig neue Objekte zu erstellen
        //S wird so lange zum StringBuilder hinzugefügt, wie der Faktor n größer als 0 ist.
        // In jedem Schleifenzyklus wird n um eins reduziert
        do {
            text.append(S);
            n--;
        } while (n > 0);
        return text.toString();
    }


    /**
     * Diese Methode nimmt einen String entgegen und gibt einen neuen String zurück, bei dem das erste Zeichen
     * großgeschrieben und der Rest kleingeschrieben wird.
     *
     * @param s String, der formatiert werden soll
     * @return neuer String mit dem ersten Zeichen großgeschrieben und dem Rest kleingeschrieben
     * @throws NullPointerException wenn s == null
     * @throws IllegalArgumentException wenn Länge des Strings < 1
     */
    public static String formatString(String s) throws IllegalArgumentException {
        try {
            if (s == null) {
                throw new NullPointerException();
            } else if (s.length() < 2) {
                throw new IllegalArgumentException();
            } else {
                return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            }
        } catch (NullPointerException ee) {
            throw new NullPointerException("Der String darf nicht leer sein");
        } catch (IllegalArgumentException eee) {
            throw new IllegalArgumentException("Der String muss mindestens die Länge eins haben!");
        }
    }
}
