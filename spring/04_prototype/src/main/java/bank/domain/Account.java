package bank.domain;

public abstract class Account {

    String number;
    String currency;
    long balance;

    public Account() {
    }

    public Account(String number, String currency, long balance) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
    }

    public abstract String getPrototypeBeanName();

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
