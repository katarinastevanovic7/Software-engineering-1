package exercise02.bank_account;

public class NoDebtsBankAccount extends BankAccount {

    public NoDebtsBankAccount(String name, int accountNumber) {
        super(name, accountNumber);
    }
    //code ab hier
    @Override
    public void withdrawMoney(int cents) {
        if (cents < 0) {
            // Negative Beträge sind nicht erlaubt
            throw new IllegalArgumentException("cents must not be negative");
        }

        if (cents > balanceInCents) {
            // Nicht genügend Geld auf dem Konto
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balanceInCents -= cents;
    }
}

