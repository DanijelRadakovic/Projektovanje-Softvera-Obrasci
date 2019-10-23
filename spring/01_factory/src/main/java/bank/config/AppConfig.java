package bank.config;

import bank.repository.account.AccountRepositoryFactory;
import bank.repository.transfer.TransferRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("transferRepository")
    public TransferRepositoryFactory jpaTransferRepositoryFactory() {
        return new TransferRepositoryFactory("jpa");
    }

    @Bean("accountRepository")
    public AccountRepositoryFactory jpaAccountRepositoryFactory() {
        return new AccountRepositoryFactory("jpa");
    }
}
