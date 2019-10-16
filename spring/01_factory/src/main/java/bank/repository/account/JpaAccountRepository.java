package bank.repository.account;

import bank.model.Account;
import bank.model.Amount;

import java.math.BigDecimal;

public class JpaAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(
                accountId,
                "Corey Taylor",
                new Amount(new BigDecimal(5000))
        );
    }
}
