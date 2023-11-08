package exercise02.bank_account;

public class Account {

    protected String name;
    protected int accountNumber;

    Account() {
    }

    public Account(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
