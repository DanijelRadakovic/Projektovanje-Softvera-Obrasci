package bank.service;

import bank.repository.account.AccountRepositoryFactory;
import bank.repository.transfer.TransferRepositoryFactory;

/*
This design pattern is based on the GOF factory design pattern to create object
instances by using a factory method. So this method actually centralizes the use
of the new operator. It creates the object instances based on the information
provided by the client code.
*/
public class TransferServiceFactory {

    public static TransferService getJpaTransferService() {
        return new TransferServiceImpl(
                AccountRepositoryFactory.getInstance("jpa"),
                TransferRepositoryFactory.getInstance("jpa")
        );
    }

    public static TransferService getJdbcTransferService() {
        return new TransferServiceImpl(
                AccountRepositoryFactory.getInstance("jdbc"),
                TransferRepositoryFactory.getInstance("jdbc")
        );
    }

    public static TransferService getInstance(String accountRepoType, String transferRepoType) {
        return new TransferServiceImpl(
                AccountRepositoryFactory.getInstance(accountRepoType),
                TransferRepositoryFactory.getInstance(transferRepoType)
        );
    }
}
