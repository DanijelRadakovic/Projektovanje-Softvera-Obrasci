package bank.repository.account;

import bank.domain.Account;

public interface AccountRepository {

    Account findByAccountId(Long accountId);
}
