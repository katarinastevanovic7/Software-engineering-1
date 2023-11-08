package exercise03.ConversionTest;

import exercise03.currency.Conversion;
import exercise03.currency.Currency;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConversionTest {
    @Test
    public void testConversion() {
        //Test der einfachen Konvertierung von EUR zu USD
        double usdToEur = Conversion.convert(100.0, Currency.EUR, Currency.USD);
        assertEquals(107.0, usdToEur, 0.01);

        //Test der einfachen Konvertierung von EUR zu CHF
        double chfToEur = Conversion.convert(200.0, Currency.EUR, Currency.CHF);
        assertEquals(192.0, chfToEur, 0.01);

        //Test der einfachen Konventierung von EUR zu YEN
        double yenToEur = Conversion.convert(300.0, Currency.EUR, Currency.YEN);
        assertEquals(48_246.0, yenToEur, 0.01);

        //Test der Hin- und Rückkonvertierung von EUR zu USD und zurück
        double initialAmountUSD = 150.0;
        double usdToEur2 = Conversion.convert(initialAmountUSD, Currency.USD, Currency.EUR);
        double eurToUSD = Conversion.convert(usdToEur2, Currency.EUR, Currency.USD);
        assertEquals(initialAmountUSD, eurToUSD, 0.01);

    }
}
