package bank.model;

import java.math.BigDecimal;

public class Amount {

    private BigDecimal balance;

    public Amount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
