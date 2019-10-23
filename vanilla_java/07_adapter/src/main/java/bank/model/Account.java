package bank.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Account {

    private String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        if (id.matches("[0-9]{3}-[0-9]{10}-[0-9]{2}")) {
            this.id = id;
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Not valid account number");
        }
    }

    public Account(String id, double balance) {
        if (id.matches("[0-9]{3}-[0-9]{10}-[0-9]{2}")) {
            this.id = id;
            this.balance = new BigDecimal(balance);
        } else {
            throw new IllegalArgumentException("Not valid account number");
        }
    }

    public void add(Amount amount) {
        balance = balance.add(amount.getAmount());
    }

    public void subtract(Amount amount) {
        balance = balance.subtract(amount.getAmount());
    }
}
