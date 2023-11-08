package exercise02.bank_account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NoDebtsBankAccountTest {

    @Test
    public void createNoDebtsBankAccount() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        assertEquals("Test-Account", bankAccount.getName());
        assertEquals(123, bankAccount.getAccountNumber());
        assertEquals(0, bankAccount.getBalanceInCents());
    }

    //code ab hier
    @Test
    public void addMoney() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.addMoney(1000);
        assertEquals(1000, bankAccount.getBalanceInCents());
    }

    @Test
    public void withdrawMoney() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.addMoney(1000);
        bankAccount.withdrawMoney(500);
        assertEquals(500, bankAccount.getBalanceInCents());
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawMoneyNegativeAmount() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.withdrawMoney(-100); // Erwartet IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawMoneyInsufficientFunds() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.withdrawMoney(100); // Erwartet IllegalArgumentException, da das Konto leer ist
    }

   @Test
    public void toStringPositiveBalance() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.addMoney(1000);
        assertEquals("BankAccount{nr=123, name=Test-Account, balance=+10.00}", bankAccount.toString());
    }

    @Test
    public void toStringNegativeBalance() {
        NoDebtsBankAccount bankAccount = new NoDebtsBankAccount("Test-Account", 123);
        bankAccount.withdrawMoney(5000);
        assertEquals("BankAccount{nr=123, name=Test-Account, balance=-5.00}", bankAccount.toString());
    }
}
