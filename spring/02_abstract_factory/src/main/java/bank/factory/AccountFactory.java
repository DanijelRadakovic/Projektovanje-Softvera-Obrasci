package bank.factory;

import bank.repository.account.AccountRepository;
import bank.repository.account.JpaAccountRepository;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class AccountFactory implements FactoryBean<AccountRepository> {

    @Autowired
    private AccountFactory accountFactory;

    @Override
    public AccountRepository getObject() throws Exception {
        return new JpaAccountRepository();
    }

    @Override
    public Class<?> getObjectType() {
        return AccountRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @PostConstruct
    private void postConstruct() {
        accountFactory.
    }
}
