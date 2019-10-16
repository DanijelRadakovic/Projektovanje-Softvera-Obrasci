package bank.repository.transfer;

import bank.model.Account;
import bank.model.Amount;

public interface TransferRepository {

    void transfer(Account accountA, Account accountB, Amount amount);
}
