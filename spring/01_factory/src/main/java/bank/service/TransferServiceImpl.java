package bank.service;

import bank.domain.Account;
import bank.domain.Amount;
import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    private TransferRepository transferRepository;

    public TransferServiceImpl(@Qualifier("jpaAccountRepository") AccountRepository accountRepository,
                               @Qualifier("jpaTransferRepository") TransferRepository transferRepository) {
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
