package bank.lombokbuilder;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Contract {

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
}
