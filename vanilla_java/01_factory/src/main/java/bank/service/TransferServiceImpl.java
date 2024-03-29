package bank.service;

import bank.model.Account;
import bank.model.Amount;
import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;

public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    private TransferRepository transferRepository;

    // This is Dependency Injection, more specifically Constructor Injection
    public TransferServiceImpl(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public void transferAmount(Long a, Long b, Amount amount) {
        Account accountA = accountRepository.findByAccountId(a);
        Account accountB = accountRepository.findByAccountId(b);
        transferRepository.transfer(accountA, accountB, amount);
    }

}
