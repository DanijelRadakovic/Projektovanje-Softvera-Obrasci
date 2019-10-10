package bank;

import bank.model.Amount;
import bank.repository.account.AccountRepositoryFactory;
import bank.repository.transfer.TransferRepositoryFactory;
import bank.service.TransferService;
import bank.service.TransferServiceImpl;

import java.math.BigDecimal;

public class BankApplication {

    public static void main(String[] args) {
        TransferService transferService;
        Long georgeId, coreyId;
        Amount amount;

        georgeId = 1L; coreyId = 2L;
        amount = new Amount(new BigDecimal(2000));


        // get transfer service based on JPA repositories
        transferService = new TransferServiceImpl(
                AccountRepositoryFactory.getInstance("jpa"),
                TransferRepositoryFactory.getInstance("jpa")
        );
        transferService.transferAmount(georgeId, coreyId, amount);

        // get transfer service based on JDBC repositories
        transferService = new TransferServiceImpl(
                AccountRepositoryFactory.getInstance("jdbc"),
                TransferRepositoryFactory.getInstance("jdbc")
        );
        transferService.transferAmount(georgeId, coreyId, amount);

        // get transfer service with custom repositories
        transferService = new TransferServiceImpl(
                AccountRepositoryFactory.getInstance("jpa"),
                TransferRepositoryFactory.getInstance("jdbc")
        );
        transferService.transferAmount(georgeId, coreyId, amount);
    }
}
