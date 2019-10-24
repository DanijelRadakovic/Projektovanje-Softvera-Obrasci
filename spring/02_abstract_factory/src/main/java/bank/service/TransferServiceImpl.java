package bank.service;

import bank.factory.TransferServiceAbstractFactory;
import bank.domain.Account;
import bank.domain.Amount;
import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    private TransferRepository transferRepository;

    public TransferServiceImpl(TransferServiceAbstractFactory factory) {
        this.accountRepository = factory.getAccountRepository();
        this.transferRepository = factory.getTransferRepository();
    }

    @Override
    public void transferAmount(Long a, Long b, Amount amount) {
        Account accountA = accountRepository.findByAccountId(a);
        Account accountB = accountRepository.findByAccountId(b);
        transferRepository.transfer(accountA, accountB, amount);
    }

}
