package bank.lombokbuilder;

import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class ContractReport {

    private String personalID;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String placeOfBirth;
    private String address;
    private String occupation;
    private String company;
    private Double salary;

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
}
