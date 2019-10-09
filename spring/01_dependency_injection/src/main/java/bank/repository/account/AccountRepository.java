package bank.repository.account;

import bank.model.Account;

public interface AccountRepository {

    Account findByAccountId(Long accountId);
}
