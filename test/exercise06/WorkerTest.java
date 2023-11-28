package exercise06;

import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {

    @Test
    public void getNameInUpperCaseValid() {
        Worker Isci = new Worker();
        Isci.initialize("Isci");

        String upperIsci = Isci.getNameInUpperCase();
        Assert.assertEquals("ISCI", upperIsci);
    }

    @Test
    public void getNameInUpperCaseError() {
        Worker Isci = new Worker();
        try {
            String upperIsci = Isci.getNameInUpperCase();
            Assert.fail("Illegal State Exception thrown");
        } catch (IllegalStateException iae) {
            Assert.assertEquals("initialize has to be called first", iae.getMessage());
        }
    }
}
