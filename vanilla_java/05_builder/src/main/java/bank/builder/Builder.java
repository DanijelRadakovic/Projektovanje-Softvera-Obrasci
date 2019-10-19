package bank.builder;

import java.time.LocalDate;
/*
Builder Pattern

Separate the construction of a complex object from its representation so that the
same construction process can create different representations. - GOF Design
Patterns

The Builder design pattern is used to construct a complex object step by step, and
finally it will return the complete object. The logic and process of object creation
should be generic so that you can use it to create different concrete implementations
of the same object type. This pattern simplifies the construction of complex objects
and it hides the details of the object's construction from the client caller code. When
you are using this pattern, remember you have to build it one step at a time, which
means you have to break the object construction login into multiple phases, unlike
other patterns, such as the abstract factory and the factory method pattern, which the
object is built in a single step.
*/
public interface Builder<ConcreteBuilder extends Builder, Product> {

    ConcreteBuilder setPersonalID(String personalID);

    ConcreteBuilder setFirstName(String firstName);

    ConcreteBuilder setParentsName(String parentsName);

    ConcreteBuilder setLastName(String lastName);

    ConcreteBuilder setDateOfBirth(LocalDate dateOfBirth);

    ConcreteBuilder setCountryOfBirth(String countryOfBirth);

    ConcreteBuilder setPlaceOfBirth(String placeOfBirth);

    ConcreteBuilder setAddress(String address);

    ConcreteBuilder setOccupation(String occupation);

    ConcreteBuilder setCompany(String company);

    ConcreteBuilder setSalary(Double salary);

    Product build();
}
