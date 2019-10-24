package bank.factory;

import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;

class JpaTransferServiceFactory extends TransferServiceAbstractFactory {

    @Override
    public AccountRepository getAccountRepository() {
        return AccountRepositoryFactory.getInstance("jpa");
    }

    @Override
    public TransferRepository getTransferRepository() {
        return TransferRepositoryFactory.getInstance("jpa");
    }
}