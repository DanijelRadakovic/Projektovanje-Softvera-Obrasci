package bank.repository.transfer;

import bank.domain.Account;
import bank.domain.Amount;

class JpaTransferRepository implements TransferRepository {

    @Override
    public void transfer(Account accountA, Account accountB, Amount amount) {
        System.out.println("Transaction has been executed via JPA implementation");
    }

}
