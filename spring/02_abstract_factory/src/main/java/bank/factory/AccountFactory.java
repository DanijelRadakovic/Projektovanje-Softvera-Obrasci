package bank.factory;

import bank.repository.account.AccountRepository;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class AccountFactory extends AbstractFactoryBean<AccountRepository> {


    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    protected AccountRepository createInstance() throws Exception {
        return null;
    }
}
