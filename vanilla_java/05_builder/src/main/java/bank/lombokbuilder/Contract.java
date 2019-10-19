package bank.lombokbuilder;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Contract {

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
}
