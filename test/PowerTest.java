import exercise01.calculator_reversed.advanced.IBinaryOperation;
import exercise01.calculator_reversed.advanced.Power;
import org.junit.Assert;
import org.junit.Test;

public class PowerTest {

    static final double DELTA = 0.00001;

    @Test
    public void testPowers() {
        IBinaryOperation power = new Power();

        Assert.assertEquals(8.0, power.calculate(2.0, 3.0), DELTA);
        Assert.assertEquals(-8.0, power.calculate(-2.0, 3.0), DELTA);
        Assert.assertEquals(0.125, power.calculate(2.0, -3.0), DELTA);
        Assert.assertEquals(-0.125, power.calculate(-2.0, -3.0), DELTA);
        Assert.assertEquals(1.0, power.calculate(3.0, 0), DELTA);
        Assert.assertEquals(5.656854249492381, power.calculate(2.0, 2.5), DELTA);
        Assert.assertEquals(0.043634488475497855, power.calculate(3.5, -2.5), DELTA);


    }
}