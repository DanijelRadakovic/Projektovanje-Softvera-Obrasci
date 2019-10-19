package bank.model;



import jdk.internal.jline.internal.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractReport {

    private String personalID;
    private String firstName;
    private String middleName; // optional
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String placeOfBirth;
    private String address;
    private String occupation; // optional
    private String company; // optional
    private Double salary; // optional

    public ContractReport() {
    }

    public ContractReport(String personalID, String firstName, @Nullable String middleName, String lastName,
                          LocalDate dateOfBirth, String countryOfBirth, String placeOfBirth, String address,
                          @Nullable String occupation, @Nullable String company, @Nullable Double salary) {
        this.personalID = personalID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.address = address;
        this.occupation = occupation;
        this.company = company;
        this.salary = salary;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        //noinspection StringBufferReplaceableByString
        return new StringBuilder()
                .append("-----REPORT-----").append("\n")
                .append("Personal ID: ").append(personalID).append("\n")
                .append("First Name: ").append(firstName).append("\n")
                .append("Last Name: ").append(lastName).append("\n")
                .append("Date Of Birth: ").append(dateOfBirth.format(
                        DateTimeFormatter.ofPattern("dd.MM.yyyy."))).append("\n")
                .append("Country Of Birth: ").append(countryOfBirth).append("\n")
                .append("Place Of Birth: ").append(placeOfBirth).append("\n")
                .append("Address: ").append(address).append("\n")
                .append("Occupation: ").append(occupation).append("\n")
                .append("Company: ").append(company).append("\n")
                .append("Salary: ").append(salary).append("\n")
                .toString();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}