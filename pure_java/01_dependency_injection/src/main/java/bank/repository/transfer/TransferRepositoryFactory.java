package bank.repository.transfer;

/*
This design pattern is based on the GOF factory design pattern to create object
instances by using a factory method. So this method actually centralizes the use
of the new operator. It creates the object instances based on the information
provided by the client code.
*/
public class TransferRepositoryFactory {

    public static TransferRepository getInstance(String type) {
        if (type.toLowerCase().equals("jpa")) {
            return new JpaTransferRepository();
        } else if (type.toLowerCase().equals("jdbc")) {
            return new JdbcTransferRepository();
        } else {
            throw new IllegalArgumentException("Could not create transfer repository, unrecognized type: " + type);
        }
    }
}
