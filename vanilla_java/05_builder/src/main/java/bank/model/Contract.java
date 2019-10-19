package bank.model;

import jdk.internal.jline.internal.Nullable;

import java.time.LocalDate;

public class Contract {

    private String personalID;
    private String firstName;
    private String middleName; // optional
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String placeOfBirth;
    private String address;
    private String occupation; // optional
    private String company;// optional
    private Double salary; // optional

    public Contract() {
    }

    public Contract(String personalID, String firstName, @Nullable String middleName, String lastName,
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
