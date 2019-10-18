package bank.builder;

import bank.model.ContractReport;

import java.time.LocalDate;

public class ContractReportBuilder implements Builder<ContractReportBuilder, ContractReport> {

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
    public ContractReportBuilder setPersonalID(String personalID) {
        this.personalID = personalID;
        return this;
    }

    @Override
    public ContractReportBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public ContractReportBuilder setParentsName(String parentsName) {
        this.parentsName = parentsName;
        return this;
    }

    @Override
    public ContractReportBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public ContractReportBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public ContractReportBuilder setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
        return this;
    }

    @Override
    public ContractReportBuilder setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    @Override
    public ContractReportBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public ContractReportBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    @Override
    public ContractReportBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public ContractReportBuilder setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public ContractReport build() {
        return new ContractReport(personalID, firstName, parentsName, lastName, dateOfBirth, countryOfBirth,
                placeOfBirth, address, occupation, company, salary
        );
    }
}
