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
            // IllegalStateException: der Zustand der aktuellen Klasse erlaubt den Methodenaufruf nicht
            //Versucht, den in Großbuchstaben geschriebenen Namen mit getNameInUpperCase abzurufen,
            // ohne zuerst initialize aufzurufen
        }
    }
}
