package bank.repository.transfer;

/*
Factory Pattern

Define an interface for creating an object, but let subclasses decide which class to
instantiate. Factory Method lets a class defer instantiation to subclasses.
- GOF Design Pattern

The Factory design pattern is also known as the Factory method design pattern because
it uses factory method in order to crate object instances. So this method actually
centralizes the use of the new operator. It creates the object instances based on the
information provided by the client code. According to this design pattern,
you get an object of a class without exposing the underlying logic to the client. It
assigns a new object to the caller by using a common interface or abstract class. This
means that the design pattern hides the actual logic of the implementation of an
object, how to create it, and which class to instantiate it in. So the client shouldn't
worry about creating, managing, and destroying an object-the Factory pattern takes
responsibility for these tasks.
*/
public class TransferRepositoryFactory {

    private static final String JPA_TRANSFER = "jpa";
    private static final String JDBC_TRANSFER = "jdbc";

    public static TransferRepository getInstance(String type) {
        if (type.toLowerCase().equals(JPA_TRANSFER)) {
            return new JpaTransferRepository();
        } else if (type.toLowerCase().equals(JDBC_TRANSFER)) {
            return new JdbcTransferRepository();
        } else {
            throw new IllegalArgumentException("Could not create transfer repository, unrecognized type: " + type);
        }
    }
}
