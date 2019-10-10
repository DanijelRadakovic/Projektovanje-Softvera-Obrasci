package bank;

/*
Singleton Pattern Eager Initialization

Ensure a class has only one instance and provide a global point of access
to it - GOF Design Patterns

The class is responsible for creating an object and also ensures that only a single
object should be created for each client call for this object. This class doesn't
allow a direct instantiation of an object of this class. It allows you to get an
object instance only by an exposed static method.

This is a variation of Singleton pattern where eager initialization is used.
*/
public class SSHConnection {

    private static final SSHConnection INSTANCE = new SSHConnection();

    private SSHConnection() {}

    public static SSHConnection getInstance() {
        return INSTANCE;
    }
}
