package bank.service;

import bank.model.Account;
import bank.model.Amount;

public interface MobilePaymentGateway {

    void doMobileTransaction(String device, Account account1, Account account2, Amount amount);
}
