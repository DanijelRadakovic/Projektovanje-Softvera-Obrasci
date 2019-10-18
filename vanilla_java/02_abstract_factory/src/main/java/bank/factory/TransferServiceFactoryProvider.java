package bank.factory;

public class TransferServiceFactoryProvider {

    private static final String JPA_FACTORY = "jpa";
    private static final String JDBC_FACTORY = "jdbc";

    public static TransferServiceAbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase(JPA_FACTORY)) {
            return new JpaTransferServiceFactory();
        } else if (choice.equalsIgnoreCase(JDBC_FACTORY)) {
            return new JdbcTransferServiceFactory();
        } else {
            throw new IllegalArgumentException("Could not get transfer service factory, unrecognized type:" + choice);
        }
    }
}
