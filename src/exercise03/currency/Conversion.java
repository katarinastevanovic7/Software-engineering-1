package exercise03.currency;

public class Conversion {

    public static double convert(double amount, Currency from, Currency to) {
        //TODO
        //Wechselkurs von Ausgangswährung zum Euro
        double fromEuroRate = from.getEuroConversionFactor();

        //Wechselkurs von Zielwährung zum Euro
        double toEuroRate = to.getEuroConversionFactor();

        //Betrag in Euro umrechnen
        double euroAmount = amount/ fromEuroRate;

        //Betrag in Zielwährung umrechnen
        double result = euroAmount * toEuroRate;

        return result;
        }
    }

// Bonusaufgabe
//    public static BigDecimal convert(BigDecimal amount, Currency from, Currency to) {
//        // TODO
//    }

