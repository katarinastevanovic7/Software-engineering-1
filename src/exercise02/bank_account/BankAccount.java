package exercise02.bank_account;

import java.util.Locale;
import java.util.Objects;

public class BankAccount extends Account {

    protected int balanceInCents;

    public BankAccount(String name, int accountNumber) {
        super(name, accountNumber);
        this.balanceInCents = 0;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public void addMoney(int cents) {
        if (cents < 0) {
            // negative amount
            throw new IllegalArgumentException("cents must not be negative");
        }
        this.balanceInCents += cents;
    }

    public void withdrawMoney(int cents) {
        if (cents < 0) {
            // negative amount
            throw new IllegalArgumentException("cents must not be negative");
        }
        this.balanceInCents -= cents;
    }
        //code ab hier
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return balanceInCents == that.balanceInCents &&
                Objects.equals(name, that.name) &&
                Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        int a = Objects.hash(name, accountNumber, balanceInCents);
        System.out.println(a);
        return 0;
    }

    @Override
    public String toString() {
        double balanceInEuro = balanceInCents / 100.0;
        String formattedBalance = String.format("%.2f", balanceInEuro);

        if (balanceInCents >= 0) {
            return String.format("{nr=%d, name=%s, balance=+%s}", accountNumber, name, formattedBalance);
        } else {
            return String.format("{nr=%d, name=%s, balance=%s}", accountNumber, name, formattedBalance);
        }

    }
}

