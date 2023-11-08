package exercise02.bank_account;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        assertEquals("Test-Account", bankAccount.getName());
        assertEquals(123, bankAccount.getAccountNumber());
        assertEquals(0, bankAccount.getBalanceInCents());
    }

    @Test
    public void addMoney() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        bankAccount.addMoney(4212);
        assertEquals(4212, bankAccount.getBalanceInCents());
        bankAccount.addMoney(1);
        assertEquals(4213, bankAccount.getBalanceInCents());
        bankAccount.addMoney(0);
        assertEquals(4213, bankAccount.getBalanceInCents());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMoneyNegativeArgument() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        bankAccount.addMoney(-1);
    }

    @Test
    public void withdrawMoneyBalanceIsPositive() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        bankAccount.addMoney(1111);
        bankAccount.withdrawMoney(111);
        assertEquals(1000, bankAccount.getBalanceInCents());
        bankAccount.addMoney(14);
        assertEquals(1014, bankAccount.getBalanceInCents());
        bankAccount.withdrawMoney(3);
        assertEquals(1011, bankAccount.getBalanceInCents());
        bankAccount.withdrawMoney(0);
        assertEquals(1011, bankAccount.getBalanceInCents());
    }

    @Test
    public void withdrawMoneyBalanceGetsNegative() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        bankAccount.withdrawMoney(111);
        assertEquals(-111, bankAccount.getBalanceInCents());
        bankAccount.addMoney(14);
        assertEquals(-97, bankAccount.getBalanceInCents());
        bankAccount.withdrawMoney(3);
        assertEquals(-100, bankAccount.getBalanceInCents());
        bankAccount.withdrawMoney(0);
        assertEquals(-100, bankAccount.getBalanceInCents());
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawMoneyNegativeArgument() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        bankAccount.addMoney(10);
        bankAccount.withdrawMoney(-1);
    }

    @Test
    public void testToStringZero() {
        BankAccount bankAccount = new BankAccount("Test-Account", 123);
        assertEquals("BankAccount{nr=123, name=Test-Account, balance=+0.00}", bankAccount.toString());
    }

    @Test
    public void testToStringPlus912() {
        BankAccount bankAccount = new BankAccount("Konto", 2);
        bankAccount.addMoney(912);
        assertEquals("BankAccount{nr=2, name=Konto, balance=+9.12}", bankAccount.toString());
    }

    @Test
    public void testToStringMinus12331() {
        BankAccount bankAccount = new BankAccount("Mit Leerzeichen", 2222222);
        bankAccount.withdrawMoney(12331);
        assertEquals("BankAccount{nr=2222222, name=Mit Leerzeichen, balance=-123.31}", bankAccount.toString());
    }
}