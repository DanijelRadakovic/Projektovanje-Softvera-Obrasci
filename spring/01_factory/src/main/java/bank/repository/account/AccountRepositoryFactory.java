package bank.repository.account;

import org.springframework.beans.factory.FactoryBean;

/*
Factory Pattern

Define an interface for creating an object, but let subclasses decide which class to
instantiate. Factory Method lets a class defer instantiation to subclasses.
- GOF Design Pattern

The Factory design pattern is also known as the Factory method design pattern because
it uses factory method in order to crate object instances. So this method actually
centralizes the use of the new operator. It creates the object instances based on the
information provided by the client.
*/
public class AccountRepositoryFactory implements FactoryBean<AccountRepository> {

    private static final String JPA_ACCOUNT = "jpa";
    private static final String JDBC_ACCOUNT = "jdbc";

    private String accountType;

    public AccountRepositoryFactory(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public AccountRepository getObject() throws Exception {
        if (accountType.equalsIgnoreCase(JPA_ACCOUNT)) {
            return new JpaAccountRepository();
        } else if (accountType.equalsIgnoreCase(JDBC_ACCOUNT)) {
            return new JdbcAccountRepository();
        } else {
            throw new UnsupportedOperationException("Could not create account repository, unrecognized type: "
                    + accountType);
        }
    }

    @Override
    public Class<?> getObjectType() {
        return AccountRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
