package bank.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Amount {

    private BigDecimal amount;

    public Amount(BigDecimal amount) throws IllegalArgumentException {
        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount has to be greater than 0");
        }
    }

    public Amount(double amount) throws IllegalArgumentException{
        if (amount > 0) {
            this.amount = new BigDecimal(amount);
        } else {
            throw new IllegalArgumentException("Amount has to be greater than 0");
        }
    }

}
