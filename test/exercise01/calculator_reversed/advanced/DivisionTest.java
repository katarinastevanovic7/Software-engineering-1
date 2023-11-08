package exercise01.calculator_reversed.advanced;

import exercise01.calculator_reversed.advanced.Division;
import exercise01.calculator_reversed.advanced.IBinaryOperation;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {

    static final double DELTA = 0.00001;

    @Test
    public void numbersBothPositive() {
        // GIVEN: Instanz von Division
        IBinaryOperation division = new Division();

        //WHEN: 10.0 durch 5.0 wird berechnet
        double result = division.calculate(10.0, 5.0);

        // THEN: Ergebnis ist 2.0
        Assert.assertEquals(2.0, result, DELTA);
        //assertEquals um zu überprüfen, dass der erwartete Wert mit dem tatsächlichen Wert übereinstimmt
        //DELTA: ermöglicht es, Gleitkommazahlen auf eine bestimmte Genauigkeit zu vergleichen,
        // ohne, dass der Test fehlschlägt, wenn es zu geringfügigen Rundungsfehlern kommt

    }

    @Test
    public void numbersOnePositive() {
        // GIVEN: Instanz von Division
        IBinaryOperation division = new Division();

        //WHEN: -1.0 durch 3.0 wird berechnet
        double result = division.calculate(-1.0, 3.0);

        // THEN: Ergebnis ist -0.333333333333
        Assert.assertEquals(-1.0/3, result, DELTA);
    }

    @Test
    public void numbersBothNegative() {
        // GIVEN: Instanz von Division
        IBinaryOperation division = new Division();

        //WHEN: -10.0 durch -25.0 wird berechnet
        double result = division.calculate(-10.0, -25.0);

        // THEN: Ergebnis ist 0.4
        Assert.assertEquals(0.4, result, DELTA);
    }

    @Test
    public void numbersOneZero() {
        // GIVEN: Instanz von Division
        IBinaryOperation division = new Division();

        //WHEN: 42.0 durch 0 wird berechnet
        double result = division.calculate(42.0, 0);

        // THEN: Ergebnis ist Double.POSITIVE_INFINITY
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
    }
}