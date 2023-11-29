package exercise06;

import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {

    //Aufgabe 2c
    @Test
    public void getNameInUpperCaseValid() {
        Worker worker = new Worker();
        worker.initialize("Katarina");

        String upperKatarina = worker.getNameInUpperCase();
        Assert.assertEquals("KATARINA", upperKatarina);
    }

    @Test
    public void getNameInUpperCaseError() {
        Worker worker = new Worker();
        try {
            String upperKatarina = worker.getNameInUpperCase();
            Assert.fail("Illegal State Exception thrown");
        } catch (IllegalStateException iae) {
            Assert.assertEquals("initialize has to be called first", iae.getMessage());
        }
    }
}
