package exercise08;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IpvqAddressTest {

    @Test
    public void immutableClass() {
        // checking all methods of IpvqAddress. There should not be a setter method.
        for (Method method : IpvqAddress.class.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                Assert.fail("An immutable class should not have a setter method. " +
                        "Remove " + method.getName() + "!");
            }
        }

        // checking all fields of IpvqAddress.
        // All fields should be final.
        // All non-static fields should be private.
        for (Field field : IpvqAddress.class.getDeclaredFields()) {
            if (!Modifier.isFinal(field.getModifiers())) {
                Assert.fail("An immutable class should only have final fields. " +
                        "Found non-final field " + field.getName());
            }
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers())) {
                Assert.fail("A data class should only have private non-static fields. " +
                        "Found non-private field " + field.getName());
            }
        }
    }

    @Test
    public void testContructorAndGetter() {
        IpvqAddress address = new IpvqAddress("1;2;0;511;23");
        Assert.assertEquals(1, address.getComponent1());
        Assert.assertEquals(2, address.getComponent2());
        Assert.assertEquals(0, address.getComponent3());
        Assert.assertEquals(511, address.getComponent4());
        Assert.assertEquals(23, address.getComponent5());
    }

    @Test(expected = NullPointerException.class)
    public void testContstructorNullPointer() {
        new IpvqAddress(null);
    }

    @Test
    public void testInvalidAddresses() {
        String[] invalidIpvqAddresses = {
                "05;305;380;339;468",
                "a",
                "a;b;a;a;a",
                "1;44;111;1;b",
                "1;44;111;512;3",
                "1;644;111;2;3",
                "1; 4;111;2;3",
                "1;4;011;2;3",
                "512;1;1;1;1",
                "1;1;1;1",
                "1:1:1:1:1"
        };

        for (String invalidIpvqAddress : invalidIpvqAddresses) {
            try {
                //
                new IpvqAddress(invalidIpvqAddress);
                Assert.fail(invalidIpvqAddress + " is an invalid address. " +
                        "An IllegalArgumentException should have been thrown!");
            } catch (IllegalArgumentException e) {
                // expected exception, no further action required
            } catch (Exception e) {
                Assert.fail(invalidIpvqAddress + " is an invalid address. " +
                        "Expected an IllegalArgumentException, but got a "
                        + e.getClass().getSimpleName());
            }
        }
    }

    @Test
    public void testToString() {
        IpvqAddress address = new IpvqAddress("74;416;386;372;5");
        Assert.assertEquals("74;416;386;372;5", address.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        IpvqAddress address1 = new IpvqAddress("74;416;386;372;5");
        IpvqAddress address2 = new IpvqAddress("74;416;386;372;5");
        IpvqAddress address3 = new IpvqAddress("75;416;386;372;5");
        Assert.assertEquals(address1, address2);
        Assert.assertEquals(address2, address1);
        Assert.assertNotEquals(address1, address3);
        Assert.assertNotEquals(address3, address1);
        Assert.assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testComparator() {
        IpvqAddress address1 = new IpvqAddress("74;416;386;372;5");
        IpvqAddress address1again = new IpvqAddress("74;416;386;372;5");
        IpvqAddress address2 = new IpvqAddress("74;416;386;373;5");
        IpvqAddress address3 = new IpvqAddress("75;416;386;372;5");
        // Hence, address 1the correct ordering is address1, address2, address3

        Assert.assertTrue(address2.compareTo(address3) < 0);
        Assert.assertTrue(address3.compareTo(address2) > 0);

        Assert.assertTrue(address1.compareTo(address1again) == 0);

        Assert.assertTrue(address1.compareTo(address2) < 0);
        Assert.assertTrue(address1.compareTo(address3) < 0);
        Assert.assertTrue(address2.compareTo(address1) > 0);
        Assert.assertTrue(address3.compareTo(address1) > 0);
    }

    @Test
    public void testComparatorSpecialCase() {
        // Ich hatte eine Abnahme, bei der diese beiden Adressen falsch
        // sortiert wurden, daher hier der Test, damit das in Zukunft
        // bei anderen nicht passiert:
        IpvqAddress address1 = new IpvqAddress("100;0;0;0;0");
        IpvqAddress address2 = new IpvqAddress("0;0;0;0;200");
        int compare = address1.compareTo(address2);
        System.out.println(compare);
        Assert.assertTrue("100;0;0;0;0 kommt nach 0;0;0;0;200, also muss der " +
                "Wert größer als 0 sein", compare > 0);
    }

}