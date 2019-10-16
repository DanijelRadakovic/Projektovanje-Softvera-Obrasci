package bank;

import bank.domain.Account;
import bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String SAVING_ACCOUNT_NUMBER = "170-845130017-56";
        final String BUSINESS_ACCOUNT_NUMBER = "170-243525111-42";

        System.out.println("Saving Balance: " + repository.get(SAVING_ACCOUNT_NUMBER).getBalance());

        Account businessAcc = repository.get(BUSINESS_ACCOUNT_NUMBER);
        System.out.println("Business Balance: " + repository.get(BUSINESS_ACCOUNT_NUMBER).getBalance());

        businessAcc.setBalance(10000L);
        repository.save(businessAcc);
        System.out.println("Business Balance: " + repository.get(BUSINESS_ACCOUNT_NUMBER).getBalance());
    }
}
