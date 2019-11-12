package bank.repository.account;

import bank.domain.Account;
import bank.domain.Amount;

import java.math.BigDecimal;

class JpaAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(
                accountId,
                "Corey Taylor",
                new Amount(new BigDecimal(5000))
        );
    }
}
