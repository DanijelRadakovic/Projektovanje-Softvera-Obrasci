package bank.config;

import bank.repository.account.AccountRepositoryFactory;
import bank.repository.transfer.TransferRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("jpaTransferRepository")
    public TransferRepositoryFactory jpaTransferRepositoryFactory() {
        return new TransferRepositoryFactory("jpa");
    }

    @Bean("jpaAccountRepository")
    public AccountRepositoryFactory jpaAccountRepositoryFactory() {
        return new AccountRepositoryFactory("jpa");
    }

    @Bean("jdbcTransferRepository")
    public TransferRepositoryFactory jdbcTransferRepositoryFactory() {
        return new TransferRepositoryFactory("jdbc");
    }

    @Bean("jdbcAccountRepository")
    public AccountRepositoryFactory jdbcAccountRepositoryFactory() {
        return new AccountRepositoryFactory("jdbc");
    }

}
