package exercise07;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PairTest {
    @Test
    public void testPairWithNonNullValues() {
        Pair<String, Integer> pair = new Pair<>("Tanjiro", 1);
        assertEquals("Tanjiro", pair.getLeft());
        assertEquals(Integer.valueOf(1), pair.getRight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPairWithLeftNull() {
        Pair<String, Integer> pair = new Pair<>(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPairWithRightNull() {
        Pair<String, Integer> pair = new Pair<>("Tanjiro", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPairWithBothNull() {
        Pair<String, Integer> pair = new Pair<>(null, null);
    }
    @Test
    public void testPairAverage() {
        Pair<Integer, Double> pair1 = new Pair<>(1, 0.5);
        Pair<Double, Double> pair2 = new Pair<>(4.0, 2.0);
        assertEquals(0.75, Pair.average(pair1), 0.0001);
        assertEquals(3.0, Pair.average(pair2), 0.0001);
    }

}
