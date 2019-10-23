package bank;

import bank.domain.Amount;
import bank.repository.account.AccountRepositoryFactory;
import bank.repository.transfer.TransferRepositoryFactory;
import bank.service.TransferService;
import bank.service.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired // auto-configured transfer service
    private TransferService transferService;

    @Resource(name = "&accountRepository") // get reference to AccountRepositoryFactory
    private AccountRepositoryFactory accountRepositoryFactory;

    @Resource(name = "&transferRepository") // get reference to TransferRepositoryFactory
    private TransferRepositoryFactory transferRepositoryFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transferService.transferAmount(1L, 2L, new Amount(new BigDecimal(3000)));

        // Manually configure TransferService
        transferRepositoryFactory.setTransferType("jdbc");
        accountRepositoryFactory.setAccountType("jdbc");

        TransferService manuallyConfiguredTransferService = new TransferServiceImpl(
                accountRepositoryFactory.getObject(),
                transferRepositoryFactory.getObject()
        );

        manuallyConfiguredTransferService.transferAmount(1L, 2L,  new Amount(new BigDecimal(5000)));
    }
}
