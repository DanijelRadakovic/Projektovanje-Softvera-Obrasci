package bank.repository.transfer;

import bank.domain.Account;
import bank.domain.Amount;

public interface TransferRepository {

    void transfer(Account accountA, Account accountB, Amount amount);
}
