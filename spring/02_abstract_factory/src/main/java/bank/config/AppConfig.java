package bank.config;

import bank.factory.TransferServiceFactoryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("jpaTransferService")
    public TransferServiceFactoryProvider jpaTransferServiceAbstractFactory() {
        return new TransferServiceFactoryProvider("jpa");
    }
}
