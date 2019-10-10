package bank.factory;

import bank.repository.account.AccountRepository;
import bank.repository.transfer.TransferRepository;

/*
Abstract Factory Pattern

Provide an interface for creating families of related or dependent objects without
specifying their concrete classes. - GOF Design Patterns

According to this design pattern, you define an abstract class or interface
to create a related dependent object without specifying its concrete subclass.
You have a set of factory method design patterns, and you just put these factories
under a factory using the factory design pattern, which means that it is simply
a factory of factories.

Abstract factory knows about all (abstract) product types.
*/
public abstract class TransferServiceAbstractFactory {

    public abstract AccountRepository getAccountRepository();
    public abstract TransferRepository getTransferRepository();
}
