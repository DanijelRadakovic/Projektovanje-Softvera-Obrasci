package bank;

import bank.model.Account;
import bank.service.AccountJSONStream;
import bank.service.AccountJSONToCSVStream;
import bank.service.CSVStream;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class BankApplication {

    public static void main(String[] args) {

        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final URL jsonAccountURL = classLoader.getResource("accounts.json");
        final URL csvAccountURL = classLoader.getResource("accounts.csv");


        File jsonFile, csvFile;
        CSVStream<Account> accountCSVStream;
        List<Account> accounts;

        if (jsonAccountURL != null && csvAccountURL != null) {
            jsonFile = new File(jsonAccountURL.getPath());
            csvFile = new File(csvAccountURL.getPath());

            accountCSVStream = new AccountJSONToCSVStream(new AccountJSONStream(), jsonFile, csvFile);
            try {
                // read accounts from JSON file
                accounts = accountCSVStream.readLines();

                // find account with balance > 4000
                Optional<Account> optionalAccount = accountCSVStream.findFirst(
                        account -> account.getBalance().compareTo(new BigDecimal(4000)) > 0);
                if (optionalAccount.isPresent()) {
                    Account account = optionalAccount.get();
                    System.out.println("ID: " + account.getId() + " Balance: " + account.getBalance());
                }

                // write accounts to CSV file
                accountCSVStream.writeLines(accounts);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
