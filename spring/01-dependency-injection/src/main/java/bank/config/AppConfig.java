package bank.config;

import bank.repository.account.AccountRepository;
import bank.repository.account.JpaAccountRepository;
import bank.repository.transfer.JpaTransferRepository;
import bank.repository.transfer.TransferRepository;
import bank.service.TransferService;
import bank.service.TransferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new JpaAccountRepository();
    }

    @Bean
    public TransferRepository transferRepository() {
        return new JpaTransferRepository();
    }

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl(accountRepository(), transferRepository());
    }
}
