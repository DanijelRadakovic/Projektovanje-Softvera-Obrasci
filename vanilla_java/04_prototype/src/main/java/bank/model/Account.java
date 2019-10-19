package bank.model;
/*
Prototype Pattern

Specify the kind of objects to create using a prototypical instance, and create new
objects by copying this prototype. - GOF Design Patterns

It is determined by a prototypical instance. In the
enterprise application, object creation is costly in terms of creating and initializing
the initial properties of objects. If such a type of object is already in your hand, then
you go for the prototype pattern; you just copy an existing similar object instead of
creating it, which is time-consuming.
 */
public abstract class Account implements Cloneable {

    String number;
    String currency;
    long balance;

    public abstract Account cloneAccount();

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
