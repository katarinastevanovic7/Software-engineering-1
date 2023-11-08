package exercise03.currency;

public enum Currency {
    //TODO
    EUR(1.0),
    USD(1.07),
    CHF(0.96),
    YEN(160.82);

    final private double euroConversionFactor; //privates Attribut

    Currency(double euroConversionFactor) {
        this.euroConversionFactor = euroConversionFactor;
    }
    public double getEuroConversionFactor() {
        return euroConversionFactor;
    }
}

