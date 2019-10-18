package bank.builder;

import java.time.LocalDate;

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
