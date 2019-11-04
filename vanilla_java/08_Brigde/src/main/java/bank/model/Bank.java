package bank.model;

/*
Decouple an abstraction from its implementation so that the two can vary
independently
- GoF Design Patterns: Elements of Reusable Object-Oriented Software

In software engineering, one of the most popular notions is preferred composition
over inheritance. Bridge design pattern promotes this popular notion. The approach
of the Bridge pattern is to decouple an abstraction used by the client code from its
implementation; that means it separates the abstraction and its implementation in to
separate class hierarchies. And also, Bridge pattern prefers composition over
inheritance because inheritance isn't always flexible and it breaks the encapsulation,
so any change made in the implementer affects the abstraction used by the client code.
 */
public abstract class Bank {

    // use composition over inheritance
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public abstract Account openAccount();
}
