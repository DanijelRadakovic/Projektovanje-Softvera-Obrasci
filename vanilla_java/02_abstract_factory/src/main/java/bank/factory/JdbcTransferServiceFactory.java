package bank.factory;

import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;

class JdbcTransferServiceFactory extends TransferServiceAbstractFactory {

    @Override
    public AccountRepository getAccountRepository() {
        return AccountRepositoryFactory.getInstance("jdbc");
    }

    @Override
    public TransferRepository getTransferRepository() {
        return TransferRepositoryFactory.getInstance("jdbc");
    }
}
