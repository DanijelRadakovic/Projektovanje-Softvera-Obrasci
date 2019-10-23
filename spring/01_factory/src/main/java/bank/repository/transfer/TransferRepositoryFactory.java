package bank.repository.transfer;

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
public class TransferRepositoryFactory implements FactoryBean<TransferRepository> {

    private static final String JPA_TRANSFER = "jpa";
    private static final String JDBC_TRANSFER = "jdbc";

    private String transferType;

    public TransferRepositoryFactory(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public TransferRepository getObject() throws Exception {
        if (transferType.equalsIgnoreCase(JPA_TRANSFER)) {
            return new JpaTransferRepository();
        } else if (transferType.equalsIgnoreCase(JDBC_TRANSFER)) {
            return new JdbcTransferRepository();
        } else {
            throw new UnsupportedOperationException("Could not create transfer repository, unrecognized type: "
                    + transferType);
        }
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
}
