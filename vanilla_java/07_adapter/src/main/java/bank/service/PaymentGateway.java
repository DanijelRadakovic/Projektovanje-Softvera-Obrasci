package bank.service;

import bank.model.Account;
import bank.model.Amount;

public interface PaymentGateway {

    void doTransaction(Account account1, Account account2, Amount amount);
}
