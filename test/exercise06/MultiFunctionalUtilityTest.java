package exercise06;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiFunctionalUtilityTest {

    static final double DELTA = 0.00000000001;
    //1b
    @Test
    public void testDivide() {
        assertEquals(2.0, MultiFunctionalUtility.divide(10 ,5), DELTA);
        assertEquals(1.0, MultiFunctionalUtility.divide(1 ,1), DELTA);
        assertEquals(0.5, MultiFunctionalUtility.divide(1 ,2), DELTA);
        assertEquals(-2.5, MultiFunctionalUtility.divide(-5 ,2), DELTA);
    }

    @Test
    public void testFormatString() {
        assertEquals("Hello world", MultiFunctionalUtility.formatString("hello world"));
        assertEquals("Htwg", MultiFunctionalUtility.formatString("htwg"));
        assertEquals("Kss", MultiFunctionalUtility.formatString("KSS"));
        assertEquals("Bb", MultiFunctionalUtility.formatString("bb"));
    }

    //1c
    @Test
    public void testDivideError() {
        try {
            MultiFunctionalUtility.divide(10,0);
            Assert.fail("Arithmetic Exception thrown");
        } catch (ArithmeticException e) {
            Assert.assertEquals("Division durch 0 ist nicht erlaubt!", e.getMessage());
            //.getMessage() liefert Informationen darüber, warum die Ausnahme ausgelöst wurde
        }
    }

    @Test
    public void testFormatStringError() {
        try {
            MultiFunctionalUtility.formatString(null);
            Assert.fail("NullPointerException");
        } catch (NullPointerException ee) {
            Assert.assertEquals("Der String darf nicht leer sein", ee.getMessage());
        }
        try {
            MultiFunctionalUtility.formatString("a");
            Assert.fail("Illegal Argument");
        } catch (IllegalArgumentException eee) {
            Assert.assertEquals("Der String muss mindestens die Länge eins haben!", eee.getMessage());
        }
    }
}
