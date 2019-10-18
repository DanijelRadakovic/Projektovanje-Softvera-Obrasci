package bank.builder;

import bank.model.Contract;

import java.time.LocalDate;

public class ContractBuilder implements Builder<ContractBuilder,Contract> {

    private String personalID;
    private String firstName;
    private String parentsName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String placeOfBirth;
    private String address;
    private String occupation;
    private String company;
    private Double salary;

    @Override
    public ContractBuilder setPersonalID(String personalID) {
        this.personalID = personalID;
        return this;
    }

    @Override
    public ContractBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public ContractBuilder setParentsName(String parentsName) {
        this.parentsName = parentsName;
        return this;
    }

    @Override
    public ContractBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public ContractBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public ContractBuilder setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
        return this;
    }

    @Override
    public ContractBuilder setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    @Override
    public ContractBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public ContractBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    @Override
    public ContractBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public ContractBuilder setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public Contract build() {
        return new Contract(personalID, firstName, parentsName, lastName, dateOfBirth, countryOfBirth,
                placeOfBirth, address, occupation, company, salary
        );
    }
}