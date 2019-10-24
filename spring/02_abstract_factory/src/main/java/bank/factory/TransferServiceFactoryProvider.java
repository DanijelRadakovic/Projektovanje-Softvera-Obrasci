package bank.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class TransferServiceFactoryProvider extends AbstractFactoryBean<TransferServiceAbstractFactory> {

    private static final String JPA_FACTORY = "jpa";
    private static final String JDBC_FACTORY = "jdbc";

    private String factoryType;

    public TransferServiceFactoryProvider(String factoryType) {
        this.factoryType = factoryType;
    }

    @Override
    public Class<?> getObjectType() {
        return TransferServiceAbstractFactory.class;
    }

    @Override
    public TransferServiceAbstractFactory createInstance() throws Exception {
        if (factoryType.equalsIgnoreCase(JPA_FACTORY)) {
            return new JpaTransferServiceFactory();
        } else if (factoryType.equalsIgnoreCase(JDBC_FACTORY)) {
            return new JdbcTransferServiceFactory();
        } else {
            throw new IllegalArgumentException("Could not get transfer service factory, unrecognized type:"
                    + factoryType);
        }
    }

    public String getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(String factoryType) {
        this.factoryType = factoryType;
    }
}
