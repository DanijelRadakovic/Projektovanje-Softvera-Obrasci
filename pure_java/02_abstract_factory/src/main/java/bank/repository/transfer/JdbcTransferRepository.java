package bank.repository.transfer;

import bank.model.Account;
import bank.model.Amount;

public class JdbcTransferRepository implements TransferRepository {

    @Override
    public void transfer(Account accountA, Account accountB, Amount amount) {
        System.out.println("Transaction has been executed via JDBC implementation");
    }

}
