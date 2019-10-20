package bank;

import bank.builder.ContractBuilder;
import bank.builder.ContractReportBuilder;
import bank.builder.Director;
import bank.model.Contract;
import bank.model.ContractReport;

import java.time.LocalDate;

// Lombok tutorial https://www.baeldung.com/tag/lombok/
public class BankApplication {

    public static void main(String[] args) {

        // constructing object using constructor
        Contract contract1 = new Contract(
                "123", "Anna", "Viper", "Viper",
                LocalDate.of(1993, 7, 15),
                "USA", "New York", "Washington Street 12",
                null, null, null
        );

        Contract contract2 = new Contract(
                "456", "Tom", null, "Cobain",
                LocalDate.of(1992, 10, 23),
                "USA", "New York", "Minetta Street 26",
                "Web Developer", "New York Solutions", Double.valueOf("3000")
        );

        ContractReport report = new ContractReport(
                "456", "Tom", null, "Cobain",
                LocalDate.of(1992, 10, 23),
                "USA", "New York", "Minetta Street 26",
                "Web Developer", "New York Solutions", Double.valueOf("3000")
        );
        System.out.println(report);

        // constructing object using builder directly
        ContractBuilder contractBuilder = new ContractBuilder();
        ContractReportBuilder contractReportBuilder = new ContractReportBuilder();

        contract1 = contractBuilder
                .setPersonalID("123")
                .setFirstName("Anna")
                .setLastName("Viper")
                .setParentsName("Peter")
                .setCountryOfBirth("USA")
                .setAddress("Washington Street 12")
                .setDateOfBirth(LocalDate.of(1993, 7, 15))
                .setPlaceOfBirth("New York") // no need to set null values for occupation, salary and company
                .build();

        contract2 = contractBuilder
                .setFirstName("Tom")
                .setLastName("Cobain")
                .setCountryOfBirth("USA")
                .setAddress("Minetta Street 26")
                .setDateOfBirth(LocalDate.of(1992, 10, 23))
                .setPlaceOfBirth("New York")
                .setOccupation("Web Developer")
                .setCompany("New York Solutions")
                .setSalary(Double.valueOf("3000"))
                .build();


        report = contractReportBuilder
                .setFirstName("Tom")
                .setLastName("Cobain")
                .setCountryOfBirth("USA")
                .setAddress("Minetta Street 26")
                .setDateOfBirth(LocalDate.of(1992, 10, 23))
                .setPlaceOfBirth("New York")
                .setOccupation("Web Developer")
                .setCompany("New York Solutions")
                .setSalary(Double.valueOf("3000"))
                .build();
        System.out.println(report);

        // constructing object using director
        Director director = new Director();

        director.constructBusinessContract(contractBuilder);
        contract1 = contractBuilder.build();

        director.constructSavingContract(contractReportBuilder);
        report = contractReportBuilder.build();

        System.out.println(report);

        // constructing object using lombok library
        // you need to install lombok plugin for your IDE
        // visit https://www.baeldung.com/lombok-ide
        bank.lombokbuilder.Contract contract = bank.lombokbuilder.Contract
                .builder()
                .personalID("123")
                .firstName("George")
                .lastName("Peterson")
                .build();

        System.out.println(
                bank.lombokbuilder.ContractReport
                        .builder()
                        .personalID("456")
                        .firstName("George")
                        .lastName("Peterson")
                        .dateOfBirth(LocalDate.of(1990, 5, 3))
                        .build()
        );

    }
}
