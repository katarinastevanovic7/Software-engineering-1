package exercise02.bank_account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankAccountEqualsHashCodeTest {

    @Test
    public void testSameInstanceEquals() {
        BankAccount account = new BankAccount("Test-Account", 123);
        assertTrue(account.equals(account));
    }

    @Test
    public void testEqualInstancesEquals() {
        BankAccount account1 = new BankAccount("Test-Account", 123);
        BankAccount account2 = new BankAccount("Test-Account", 123);
        assertTrue(account1.equals(account2));
    }

    @Test
    public void testDifferentNamesNotEqual() {
        BankAccount account1 = new BankAccount("Account-1", 123);
        BankAccount account2 = new BankAccount("Account-2", 123);
        assertFalse(account1.equals(account2));
    }

    @Test
    public void testDifferentNumbersNotEqual() {
        BankAccount account1 = new BankAccount("Test-Account", 123);
        BankAccount account2 = new BankAccount("Test-Account", 456);
        assertFalse(account1.equals(account2));
    }

    @Test
    public void testDifferentBalancesNotEqual() {
        BankAccount account1 = new BankAccount("Test-Account", 123);
        account1.addMoney(1000);
        BankAccount account2 = new BankAccount("Test-Account", 123);
        assertFalse(account1.equals(account2));
    }

    @Test
    public void testEqualInstancesHaveEqualHashCodes() {
        BankAccount account1 = new BankAccount("Test-Account", 123);
        BankAccount account2 = new BankAccount("Test-Account", 123);
        assertEquals(account1.hashCode(), account2.hashCode());
    }
}
