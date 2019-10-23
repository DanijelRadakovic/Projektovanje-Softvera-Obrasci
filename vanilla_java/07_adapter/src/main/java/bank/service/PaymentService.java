package bank.service;

import bank.model.Account;
import bank.model.Amount;

public class PaymentService implements PaymentGateway {

    @Override
    public void doTransaction(Account account1, Account account2, Amount amount) {
        account1.subtract(amount);
        account2.add(amount);
        System.out.println(String.format("Transferred %.2f from %s to %s",
                amount.getAmount(), account1.getId(), account2.getId()));
    }
}
