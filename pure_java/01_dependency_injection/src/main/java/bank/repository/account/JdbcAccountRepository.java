package bank.repository.account;

import bank.model.Account;
import bank.model.Amount;

import java.math.BigDecimal;

public class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(
                accountId,
                "George Fisher",
                new Amount(new BigDecimal(3000))
        );
    }

}
