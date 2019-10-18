package bank.builder;

import java.time.LocalDate;

public class Director {

    public void constructSavingContract(Builder builder) {
        builder
                .setPersonalID("123")
                .setFirstName("Anna")
                .setLastName("Viper")
                .setParentsName("Peter")
                .setCountryOfBirth("USA")
                .setAddress("Washington Street 12")
                .setDateOfBirth(LocalDate.of(1993, 7, 15))
                .setPlaceOfBirth("New York");
    }

    public void constructBusinessContract(Builder builder) {
        builder.
                setPersonalID("456")
                .setFirstName("Tom")
                .setLastName("Cobain")
                .setParentsName("John")
                .setCountryOfBirth("USA")
                .setAddress("Minetta Street 26")
                .setDateOfBirth(LocalDate.of(1992, 10, 23))
                .setPlaceOfBirth("New York")
                .setOccupation("Web Developer")
                .setCompany("New York Solutions")
                .setSalary(new Double("3000"));
    }

}
