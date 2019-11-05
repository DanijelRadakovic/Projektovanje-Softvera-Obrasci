package bank.service;

import bank.model.Account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountJSONToCSVStream implements CSVStream<Account> {

    private JSONStream<List<Account>> jsonStream;

    private List<Account> accounts;
    private File jsonFile;
    private File csvFile;
    private int lineCounter;

    public AccountJSONToCSVStream(JSONStream<List<Account>> jsonStream, File jsonFile, File csvFile) {
        this.jsonStream = jsonStream;
        this.jsonFile = jsonFile;
        this.csvFile = csvFile;
        this.lineCounter = 0;
    }

    @Override
    public Account readLine() throws IOException {
        Account account = null;

        if (accounts == null) {
            accounts = jsonStream.read(jsonFile);
        }

        if (lineCounter < accounts.size()) {
            account = accounts.get(lineCounter);
            ++lineCounter;
        }
        return account;
    }

    @Override
    public List<Account> readLines() throws IOException {
        if (accounts == null) {
            accounts = jsonStream.read(jsonFile);
        }
        lineCounter = accounts.size();
        return accounts;
    }

    @Override
    public Optional<Account> findFirst(Predicate<Account> condition) throws IOException {
        if (accounts == null) {
            accounts = jsonStream.read(jsonFile);
        }

        for (Account account : accounts) {
            if (condition.test(account)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }


    @Override
    public void writeLines(List<Account> t) throws IOException {
        Files.write(csvFile.toPath(), toCSVFormat(t).getBytes());
    }

    private String toCSVFormat(List<Account> accounts) {
        StringBuilder sb = new StringBuilder();
        accounts.forEach(account -> sb.append(
                String.format("%s,%.2f\n", account.getId(), account.getBalance().doubleValue())
                )
        );
        return sb.toString();
    }
}
