package bank.factory;

import bank.repository.account.AccountRepository;
import bank.repository.account.JdbcAccountRepository;
import bank.repository.account.JpaAccountRepository;

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
class AccountRepositoryFactory {

    private static final String JPA_ACCOUNT = "jpa";
    private static final String JDBC_ACCOUNT = "jdbc";

    static AccountRepository getInstance(String type) {
        if (type.equalsIgnoreCase(JPA_ACCOUNT)) {
            return new JpaAccountRepository();
        } else if (type.equalsIgnoreCase(JDBC_ACCOUNT)) {
            return new JdbcAccountRepository();
        } else {
            throw new IllegalArgumentException("Could not create account repository, unrecognized type: " + type);
        }
    }
}
