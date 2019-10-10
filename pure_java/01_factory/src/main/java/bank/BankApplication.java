package bank;

import bank.model.Amount;
import bank.service.TransferService;
import bank.service.TransferServiceFactory;

import java.math.BigDecimal;

public class BankApplication {

    public static void main(String[] args) {
        TransferService transferService;
        Long georgeId, coreyId;
        Amount amount;

        georgeId = 1L; coreyId = 2L;
        amount = new Amount(new BigDecimal(2000));


        // get transfer service based on JPA repositories
        transferService = TransferServiceFactory.getJpaTransferService();
        transferService.transferAmount(georgeId, coreyId, amount);

        // get transfer service based on JDBC repositories
        transferService = TransferServiceFactory.getJdbcTransferService();
        transferService.transferAmount(georgeId, coreyId, amount);

        // get transfer service with custom repositories
        transferService = TransferServiceFactory.getInstance("jdbc", "jpa");
        transferService.transferAmount(georgeId, coreyId, amount);
    }
}
