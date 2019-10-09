package bank.repository.account;

/*
This design pattern is based on the GOF factory design pattern to create object
instances by using a factory method. So this method actually centralizes the use
of the new operator. It creates the object instances based on the information
provided by the client code.
*/
public class AccountRepositoryFactory {

    private static final String JPA_ACCOUNT = "jpa";
    private static final String JDBC_ACCOUNT = "jdbc";

    public static AccountRepository getInstance(String type) {
        if (type.toLowerCase().equals(JPA_ACCOUNT)) {
            return new JpaAccountRepository();
        } else if (type.toLowerCase().equals(JDBC_ACCOUNT)) {
            return new JdbcAccountRepository();
        } else {
            throw new IllegalArgumentException("Could not create account repository, unrecognized type: " + type);
        }
    }
}
