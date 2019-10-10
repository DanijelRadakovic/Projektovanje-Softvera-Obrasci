package bank;

/*
Singleton Pattern Lazy Initialization

Ensure a class has only one instance and provide a global point of access
to it - GOF Design Patterns

The class is responsible for creating an object and also ensures that only a single
object should be created for each client call for this object. This class doesn't
allow a direct instantiation of an object of this class. It allows you to get an
object instance only by an exposed static method.

This is a variation of Singleton pattern where lazy initialization is used.
*/
public class DataBaseConnection {

    private static DataBaseConnection instance;

    private DataBaseConnection() {}

    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }
}
