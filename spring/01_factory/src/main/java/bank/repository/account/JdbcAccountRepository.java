package bank.repository.account;

import bank.domain.Account;
import bank.domain.Amount;

import java.math.BigDecimal;

class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(
                accountId,
                "George Fisher",
                new Amount(new BigDecimal(3000))
        );
    }

}
